package com.tommypacker.tipcalculator;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

/**
 * Created by tommypacker on 7/20/15.
 */
public class InputFragment extends Fragment implements SplitBillDialog.onSplitSubmit{

    private onSubmit displayResult;
    private EditText price;
    private TextView tipView;
    private int tipValue = 15;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.input_layout, container, false);
        price = (EditText) view.findViewById(R.id.MealPrice);
        SeekBar tipBar = (SeekBar) view.findViewById(R.id.tipSeekBar);
        tipView = (TextView) view.findViewById(R.id.TipRate);
        tipView.setText(Integer.toString(tipValue));


        tipBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tipValue = progress;
                tipView.setText(Integer.toString(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

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

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
           displayResult = (onSubmit) activity;
        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    public void calculateValues(){
        if(price.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Please enter a valid number", Toast.LENGTH_SHORT).show();
        }
        else {
            double mealPrice = Double.parseDouble(price.getText().toString());


            if (mealPrice < 0) {
                Toast.makeText(getActivity(), "Please enter a valid number", Toast.LENGTH_SHORT).show();
                return;
            }
            double tipsFromCalculator = Calculator.tipsPerOnePerson(mealPrice, tipValue);
            displayResult.onUserSubmit(mealPrice, tipsFromCalculator);
        }
    }

    public void calculateSplitValues(int numPeople){
        if(price.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Please enter a valid number", Toast.LENGTH_SHORT).show();
        }else{
            double mealPrice = Double.parseDouble(price.getText().toString());

            if(mealPrice < 0 || numPeople < 0){
                Toast.makeText(getActivity(), "Please enter a valid number", Toast.LENGTH_SHORT).show();
                return;
            }

            double mealPricePerPerson = Calculator.mealPricePerPerson(mealPrice, numPeople);
            double tipsPerPerson = Calculator.tipsPerMultiplePeople(mealPrice, tipValue, numPeople);
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
