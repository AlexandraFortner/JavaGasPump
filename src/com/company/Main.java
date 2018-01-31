package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("What type of gas would you like?\n[R]egular [M]id-Grade [P]remium");
        String gasType = reader.nextLine();
    }
}
