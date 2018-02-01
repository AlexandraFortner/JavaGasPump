package com.company;
import java.io.*;
import java.util.Scanner;

public class Receipt {

    public static void writeToSales(String gasType, double gallons, double money) {
        //Meant to write to Sales.txt. A summary of all past transactions.
        String fileName = "/home/basecamp/IdeaProjects/GasPump/src/com/company/Sales.txt";
        try {
            FileWriter fileWriter =
                    new FileWriter(fileName, true);

            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

            bufferedWriter.write(String.format("%s, %s, %s", gasType, gallons, money));
            bufferedWriter.newLine();

            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                    "Error writing to file '"
                            + fileName + "'");
        }
    }

    public static void checkTank() {
        //Reads GasTank.txt. Reads the inventory and price of all gas types.
        String fileName = "/home/basecamp/IdeaProjects/GasPump/src/com/company/GasTank.txt";
        String line = null;
        try {
            FileReader fileReader =
                    new FileReader(fileName);
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);
            System.out.println("\nGas Tank Inventory:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("\n");
            bufferedReader.close();
    }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
    }
    public static Double payBefore(String gasType, double money){
        //For the pay before option. Customer pays before getting gas.
        if (gasType.equals("Regular")){
            double gallons = money / 1.79;
            System.out.println("\nYou\"ve purchased " + gallons + " gallons for " +
                    money +
                    " dollars.\n\nThank you for your business! Have a nice day!");
            return gallons;
        }
        else if (gasType.equals("Mid-Grade")){
            double gallons = money / 2.00;
            System.out.println("\nYou\"ve purchased " + gallons + " gallons for " +
                    money +
                    " dollars.\n\nThank you for your business! Have a nice day!");
            return gallons;
        }
        else if (gasType.equals("Premium")){
            double gallons = money / 3.00;
            System.out.println("\nYou\"ve purchased " + gallons + " gallons for " +
                    money +
                    " dollars.\n\nThank you for your business! Have a nice day!");
            return gallons;
        }
        else{
            System.out.println("Invalid Input.");
            return null;
        }
    }

    public static Double payAfter(String gasType, double gallons){
        //For the pay after option. Customer pays after getting gas.
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
        //Calculates the state sales tax. Works with CountySalesTax and receipt.
        double stateTax = 0.08;
        return money * stateTax;
    }

    public static double CountySalesTax(double money){
        //Calculates the county sales tax. Works with StateSalesTax and receipt.
        double countyTax = 0.07;
        return money * countyTax;
    }

    public static void receipt(double money){
        //Calculates the total money owed. Works with CountySalesTax and StateSalesTax.
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
