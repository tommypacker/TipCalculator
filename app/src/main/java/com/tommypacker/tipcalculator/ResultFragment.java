package com.tommypacker.tipcalculator;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

/**
 * Created by tommypacker on 7/20/15.
 */
public class ResultFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.result_layout, container, false);
        return view;
    }

    public void setText(double mealPrice, double endTip){
        DecimalFormat df = new DecimalFormat("##.00");
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);

        TextView mealPriceView = (TextView) getView().findViewById(R.id.billMealPrice);
        mealPriceView.setText("$"+df.format(mealPrice));

        TextView tipPriceView = (TextView) getView().findViewById(R.id.billTipPrice);
        tipPriceView.setText("$" + df.format(endTip));

        double mealTotal = mealPrice + endTip;
        TextView totalPriceView = (TextView) getView().findViewById(R.id.totalPrice);
        totalPriceView.setText("$" + df.format(mealTotal));
    }
}
