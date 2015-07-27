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

package com.tommypacker.tipcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.tommypacker.tipcalculator.Settings.settings;
import com.tommypacker.tipcalculator.ui.InputFragment;
import com.tommypacker.tipcalculator.ui.ResultFragment;


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
