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

public abstract class Calculator {

    public static double tipsPerOnePerson(double mealPrice, int tipRate){
        double ratePercentage = (double) tipRate * .01;
        double totalTips = ratePercentage * mealPrice;

        totalTips = Math.round(totalTips*100);
        totalTips = totalTips/100;

        return totalTips;
    }

    public static double mealPricePerPerson(double mealPrice, int numberOfPeople){
        return mealPrice/numberOfPeople;
    }

    public static double tipsPerMultiplePeople(double mealPrice, int tipRate, int numberOfPeople){
        double ratePercentage = (double) tipRate * .01;
        double totalTips = ratePercentage * mealPrice;

        totalTips = Math.round(totalTips*100);
        totalTips = totalTips/100;

        return totalTips/numberOfPeople;
    }

}
