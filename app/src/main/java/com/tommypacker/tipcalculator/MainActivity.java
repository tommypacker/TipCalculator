package com.tommypacker.tipcalculator;

import android.content.Intent;
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
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(this, settings.class));
                return true;
        }

        return super.onOptionsItemSelected(item);
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
