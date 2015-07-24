package com.tommypacker.tipcalculator;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.zip.Inflater;

/**
 * Created by tommypacker on 7/20/15.
 */
public class InputFragment extends Fragment implements SplitBillDialog.onSplitSubmit{

    private onSubmit displayResult;
    private EditText price, rate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.input_layout, container, false);
        price = (EditText) view.findViewById(R.id.MealPrice);
        rate = (EditText) view.findViewById(R.id.TipRate);

        Button split = (Button) view.findViewById(R.id.splitBill);
        split.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        Button submit = (Button) view.findViewById(R.id.SubmitButton);
        submit.setOnClickListener(new View.OnClickListener() {
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
        if(price.getText().toString().equals("") || rate.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Please enter a valid number", Toast.LENGTH_SHORT).show();
        }
        else {
            double mealPrice = Double.parseDouble(price.getText().toString());
            int tipRate = Integer.parseInt(rate.getText().toString());

            if (mealPrice < 0 || tipRate < 0) {
                Toast.makeText(getActivity(), "Please enter a valid number", Toast.LENGTH_SHORT).show();
                return;
            }
            double resultFromCalculator = Calculator.tipsPerOnePerson(mealPrice, tipRate);
            displayResult.onUserSubmit(mealPrice, resultFromCalculator);
        }
    }

    public void calculateSplitValues(int numPeople){
        if(price.getText().toString().equals("") || rate.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Please enter a valid number", Toast.LENGTH_SHORT).show();
        }else{
            double mealPrice = Double.parseDouble(price.getText().toString());
            int tipRate = Integer.parseInt(rate.getText().toString());

            if(mealPrice < 0 || tipRate < 0 || numPeople < 0){
                Toast.makeText(getActivity(), "Please enter a valid number", Toast.LENGTH_SHORT).show();
                return;
            }
            double mealPricePerPerson = Calculator.mealPricePerPerson(mealPrice, numPeople);
            double tipsPerPerson = Calculator.tipsPerMultiplePeople(mealPrice, tipRate, numPeople);
            displayResult.onUserSubmit(mealPricePerPerson, tipsPerPerson);
        }
    }

    public void openDialog(){
        FragmentManager manager = getFragmentManager();
        SplitBillDialog billSplitter = new SplitBillDialog();
        billSplitter.show(manager, "Divide Bill");
        billSplitter.setOnSplitSubmitListener(this);
    }

    public void transferNumber(int numPeople){
        calculateSplitValues(numPeople);
    }

}
