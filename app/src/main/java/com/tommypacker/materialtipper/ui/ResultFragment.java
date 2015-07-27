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

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tommypacker.materialtipper.R;

import java.text.DecimalFormat;

public class ResultFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.result_layout, container, false);
        return view;
    }

    public void setText(double mealPrice, double endTip){
        DecimalFormat df = new DecimalFormat("##.00");
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);

        TextView mealPriceView = (TextView) getView().findViewById(R.id.billMealPrice);
        mealPriceView.setText("$"+df.format(mealPrice));

        TextView tipPriceView = (TextView) getView().findViewById(R.id.billTipPrice);
        tipPriceView.setText("$" + df.format(endTip));

        double mealTotal = mealPrice + endTip;
        TextView totalPriceView = (TextView) getView().findViewById(R.id.totalPrice);
        totalPriceView.setText("$" + df.format(mealTotal));
    }
}
