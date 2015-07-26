package com.tommypacker.tipcalculator;

/**
 * Created by tommypacker on 7/20/15.
 */
public abstract class Calculator {

    public static double tipsPerOnePerson(double mealPrice, double tipRate){
        double ratePercentage = tipRate * .01;
        double totalTips = ratePercentage * mealPrice;

        totalTips = Math.round(totalTips*100);
        totalTips = totalTips/100;

        return totalTips;
    }

    public static double mealPricePerPerson(double mealPrice, int numberOfPeople){
        return mealPrice/numberOfPeople;
    }

    public static double tipsPerMultiplePeople(double mealPrice, double tipRate, int numberOfPeople){
        double ratePercentage = tipRate * .01;
        double totalTips = ratePercentage * mealPrice;

        totalTips = Math.round(totalTips*100);
        totalTips = totalTips/100;

        return totalTips/numberOfPeople;
    }

}
