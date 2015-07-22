package com.tommypacker.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by tommypacker on 7/21/15.
 */
public class DisplayBill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.final_bill);
        Bundle extras = getIntent().getExtras();

        if(extras !=  null) {
            ResultFragment finalBill = (ResultFragment) getFragmentManager().findFragmentById(R.id.Result);
            finalBill.setText(extras.getDouble("priceOfMeal"), extras.getDouble("priceOfTips"));
        }
    }

}
