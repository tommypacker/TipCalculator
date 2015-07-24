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
            int peopleTotal = Integer.parseInt(numberOfPeople.getText().toString());
            communicator.transferNumber(peopleTotal);
            dismiss();
        }
        else{
            dismiss();
        }
    }
}
