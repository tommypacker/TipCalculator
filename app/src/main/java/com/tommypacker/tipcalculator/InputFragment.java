package com.tommypacker.tipcalculator;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.zip.Inflater;

/**
 * Created by tommypacker on 7/20/15.
 */
public class InputFragment extends Fragment {

    private onSubmit displayResult;
    private EditText price, rate, numPeople;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.input_layout, container, false);
        price = (EditText) view.findViewById(R.id.MealPrice);
        rate = (EditText) view.findViewById(R.id.TipRate);
        numPeople = (EditText) view.findViewById(R.id.PeopleTotal);

        Button b = (Button) view.findViewById(R.id.SubmitButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateValues();
            }
        });

        return view;
    }

    public interface onSubmit{
        void onUserSubmit(double mealPrice, double finalTips);
    }

    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
           displayResult = (onSubmit) activity;
        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    public void calculateValues(){
        double mealPrice = Double.parseDouble(price.getText().toString());
        int tipRate = Integer.parseInt(rate.getText().toString());
        int numberOfPeople = Integer.parseInt(numPeople.getText().toString());

        double resultFromCalculator = Calculator.tipsPerPerson(mealPrice, tipRate, numberOfPeople);
        displayResult.onUserSubmit(mealPrice, resultFromCalculator);
    }

}
