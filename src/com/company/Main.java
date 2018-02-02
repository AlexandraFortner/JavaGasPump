package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        System.out.println("What type of gas would you like?\n[R]egular [M]id-Grade [P]remium\nOtherwise [C]heck total sales.");
        String gasType = reader.nextLine();
        if (gasType.equals("r")){
            gasType = "Regular";
            System.out.println("You've chosen Regular!");
        }else if (gasType.equals("m")){
            gasType = "Mid-Grade";
            System.out.println("You've chosen Mid-Grade!");
        }else if (gasType.equals("p")){
            gasType = "Premium";
            System.out.println("You've chosen Premium!");
        }else if (gasType.equals("c")){
            Admin.addTransactions();
            System.exit(0);

        }else {
            System.out.println("Cannot compute...");
        }
        System.out.println("Would you like to:\n1. Pay Before\n2. Pay After");
        String beforeOrAfter = reader.nextLine();
        if (beforeOrAfter.equals("1")){
            System.out.println("You've chosen to Pay Before!");
            System.out.println("\nHow much money would you like to spend?\n-");
            double money = reader.nextDouble();
            double gallons = Receipt.payBefore(gasType, money);
            Receipt.receipt(money);
            Receipt.writeToSales(gasType, gallons, money);
            Receipt.checkTank(gasType, gallons);
        } else if (beforeOrAfter.equals("2")){
            System.out.println("You've chosen to Pay After!");
            System.out.println("\nHow many gallons would you like?\n-");
            double gallons = reader.nextDouble();
            double money = Receipt.payAfter(gasType, gallons);
            Receipt.receipt(money);
            Receipt.writeToSales(gasType, gallons, money);
            Receipt.checkTank(gasType, gallons);
        } else {
            System.out.println("Cannot compute...");
        }
        System.out.println("Thank you!");
    }
}
