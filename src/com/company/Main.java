package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("What type of gas would you like?\n[R]egular [M]id-Grade [P]remium");
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
        } else {
            System.out.println("Cannot compute...");
        }
        System.out.println("Would you like to:\n1. Pay Before\n2. Pay After");
        String beforeOrAfter = reader.nextLine();
        System.out.println("Thank you!");
    }
}
