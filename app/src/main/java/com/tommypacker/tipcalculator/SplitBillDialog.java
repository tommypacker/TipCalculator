package com.tommypacker.tipcalculator;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by tommypacker on 7/24/15.
 */
public class SplitBillDialog extends DialogFragment implements View.OnClickListener{

    private Button submit, cancel;
    private EditText numberOfPeople;
    private onSplitSubmit communicator;


    public SplitBillDialog(){
        //require empty constructor for DialogFragment
    }

    public void setOnSplitSubmitListener(onSplitSubmit communicator){
        this.communicator = communicator;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_splitbill_dialog, null);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        submit = (Button) view.findViewById(R.id.splitButton);
        submit.setOnClickListener(this);
        cancel = (Button) view.findViewById(R.id.cancelButton);
        cancel.setOnClickListener(this);
        numberOfPeople = (EditText) view.findViewById(R.id.numPeople);
        return view;
    }

    public interface onSplitSubmit{
        void transferNumber(int numPeople);
    }

    @Override
    public void onClick(View view){
        if(view.getId()==R.id.splitButton){
            if(numberOfPeople.getText().toString().equals("")) {
                Toast.makeText(getActivity(), "Please enter a valid number of people", Toast.LENGTH_SHORT).show();
            }
            else if(Integer.parseInt((numberOfPeople.getText().toString()))<0){
                Toast.makeText(getActivity(), "Please enter a valid number of people", Toast.LENGTH_SHORT).show();
            }
            else {
                int peopleTotal = Integer.parseInt(numberOfPeople.getText().toString());
                communicator.transferNumber(peopleTotal);
                dismiss();
            }
        }
        else{
            dismiss();
        }
    }
}
