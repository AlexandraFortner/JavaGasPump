package com.company;

import java.util.Scanner;

public class Receipt {

    public static Double payAfter(String gasType, double gallons){
        if (gasType.equals("Regular")){
            double money = gallons * 1.79;
            System.out.println("\nYou\"ve purchased " + gallons + " gallons for " +
                    money +
                    " dollars.\n\nThank you for your business! Have a nice day!");
            return money;
        }
        else if (gasType.equals("Mid-Grade")){
            double money = gallons * 2.00;
            System.out.println("\nYou\"ve purchased " + gallons + " gallons for " +
                    money +
                    " dollars.\n\nThank you for your business! Have a nice day!");
            return money;
        }
        else if (gasType.equals("Premium")){
            double money = gallons * 3.00;
            System.out.println("\nYou\"ve purchased " + gallons + " gallons for " +
                    money +
                    " dollars.\n\nThank you for your business! Have a nice day!");
            return money;
        }
    else{
        System.out.println("Invalid Input.");
        return null;
        }
    }

        public static double StateSalesTax(double money){
            double stateTax = 0.08;
            return money * stateTax;
        }

        public static double CountySalesTax(double money){
            double countyTax = 0.07;
            return money * countyTax;
        }

        public static void receipt(double money){

            double revenue = 0.0;
            double inventory = 0.0;
            System.out.println("\n___________________________________\n|\n|Original Price Of Gas:" +
                    money);
            double stateTaxes = StateSalesTax(money);
            System.out.println("\n|+ State Tax:" + stateTaxes);
            double countyTaxes = CountySalesTax(money);
            System.out.println("\n|+ County Tax:" + countyTaxes);
            double total = money + stateTaxes + countyTaxes;
            System.out.println("\n|\n|Total:" + total);
            System.out.println(
                    "\n|__________________________________\n\nHere\"s your receipt! Thank you for shopping with us!\n\n"
            );
    }

}
