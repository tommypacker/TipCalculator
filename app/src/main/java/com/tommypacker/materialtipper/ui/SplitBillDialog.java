/*
 * Copyright 2015 Tommy Yu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tommypacker.materialtipper.ui;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tommypacker.materialtipper.R;

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
        View view = inflater.inflate(R.layout.fragment_splitbill_dialog, container, false);
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
