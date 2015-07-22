package com.tommypacker.tipcalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements InputFragment.onSubmit {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onUserSubmit(double mealPrice, double finalTips) {
        ResultFragment finalResult = (ResultFragment) getFragmentManager().findFragmentById(R.id.Result);

        if(finalResult != null && finalResult.isInLayout()){
            finalResult.setText(mealPrice, finalTips);
        }else {
            Intent intent = new Intent(getApplicationContext(), DisplayBill.class);
            Bundle b = new Bundle();
            b.putDouble("priceOfMeal", mealPrice);
            b.putDouble("priceOfTips", finalTips);
            intent.putExtras(b);
            startActivity(intent);
        }

    }
}
