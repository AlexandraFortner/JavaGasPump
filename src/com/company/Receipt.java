package com.company;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Receipt {

    public static void overwriteGasTank(String regular, String midgrade, String premium) throws IOException{
        FileWriter writer = new FileWriter("/home/basecamp/IdeaProjects/GasPump/src/com/company/GasTank.txt");
        writer.write(regular);
        writer.write("\n"+midgrade);
        writer.write("\n"+premium);
        writer.close();
    }

//    public static void overwriteGasTank(String gasType, double gallons) {
//        //Meant to overwrite GasTank.txt. Subtracts the gallons that are taken by customers.
//        String fileName = "/home/basecamp/IdeaProjects/GasPump/src/com/company/GasTank.txt";
//        try {
//            FileWriter fileWriter =
//                    new FileWriter(fileName);
//            BufferedReader bufferedReader =
//                    new BufferedReader(fileReader);
//            BufferedWriter bufferedWriter =
//                    new BufferedWriter(fileWriter);
//            String str = bufferedReader.readLine();
//            String[] s = str.split(",");
//            if (gasType.equals("Regular")){
//                double regularGallons = s.split(",")[1];
//                System.out.println(regularGallons);
//                double newGallons = gallons -= regularGallons;
//                bufferedWriter.write(String.format("%s, %s, %s", "Regular", newGallons, "1.79"));
//            }
//            else if (gasType.equals("Mid-Grade")){
//                double midgradeGallons = s.split(",")[4];
//                double newGallons = gallons -= midgradeGallons;
//                bufferedWriter.write(String.format("%s, %s, %s", "Mid-Grade", gallons, "2.00"));
//            }
//            else if (gasType.equals("Premium")){
//                double premiumGallons = s.split(",")[7];
//                double newGallons = gallons -= premiumGallons;
//                bufferedWriter.write(String.format("%s, %s, %s", "Premium", gallons, "3.00"));
//            }
//            bufferedWriter.newLine();
//            bufferedWriter.close();
//        }
//        catch(IOException ex) {
//            System.out.println(
//                    "Error writing to file '"
//                            + fileName + "'");
//        }
//    }

    public static void writeToSales(String gasType, double gallons, double money) throws IOException{
        //Meant to write to Sales.txt. A summary of all past transactions.
        String fileName = "/home/basecamp/IdeaProjects/GasPump/src/com/company/Sales.txt";
        try {
            FileWriter fileWriter =
                    new FileWriter(fileName, true);

            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

            bufferedWriter.write(String.format("%s, %s, %s", gasType, money, gallons));
            bufferedWriter.newLine();

            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                    "Error writing to file '"
                            + fileName + "'");
        }
    }

    public static void checkTank(String gasType, double gallons) throws IOException {
        //Reads GasTank.txt. Reads the inventory and price of all gas types.
        File fileName =new File("/home/basecamp/IdeaProjects/GasPump/src/com/company/GasTank.txt");
        Scanner input = new Scanner(fileName);
        while (input.hasNextLine()){
            String reg = input.nextLine();
            String mid = input.nextLine();
            String prem = input.nextLine();
            if (reg.startsWith(gasType)){
                ArrayList regList = new ArrayList<String>(Arrays.asList(reg.split(", ")));
                double totalGallons = Double.parseDouble(regList.get(1).toString());
                double newTotal = totalGallons -= gallons;
                String newGallons = Double.toString(newTotal);
                reg = reg.replace(regList.get(1).toString(), newGallons);
            }else if (mid.startsWith(gasType)){
                ArrayList midList = new ArrayList<String>(Arrays.asList(mid.split(", ")));
                double totalGallons = Double.parseDouble(midList.get(1).toString());
                double newTotal = totalGallons -= gallons;
                String newGallons = Double.toString(newTotal);
                mid = mid.replace(midList.get(1).toString(), newGallons);
            }else if (prem.startsWith(gasType)){
                ArrayList premList = new ArrayList<String>(Arrays.asList(prem.split(", ")));
                double totalGallons = Double.parseDouble(premList.get(1).toString());
                double newTotal = totalGallons -= gallons;
                String newGallons = Double.toString(newTotal);
                prem = prem.replace(premList.get(1).toString(), newGallons);
            }
            overwriteGasTank(reg, mid, prem);
        }
        input.close();
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
                "\n|__________________________________\n\nHere\'s your receipt! Thank you for shopping with us!\n\n"
        );
}

}
