package com.tommypacker.tipcalculator;

/**
 * Created by tommypacker on 7/20/15.
 */
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

    public static double taxPrice(double mealPrice, double taxRate){
        double taxPercentage = taxRate/100.0;

        return mealPrice * taxPercentage;
    }
}
