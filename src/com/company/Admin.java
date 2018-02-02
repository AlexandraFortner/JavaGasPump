package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Admin {
    public static void addTransactions() throws IOException {
        //Reads and adds Sales.txt for total sales.
        File fileName =new File("/home/basecamp/IdeaProjects/GasPump/src/com/company/Sales.txt");
        Scanner input = new Scanner(fileName);
        double total_sales = 0.0;
        while (input.hasNextLine()){
                ArrayList lineList = new ArrayList<String>(Arrays.asList(input.nextLine().split(", ")));
                double totalSales = Double.parseDouble(lineList.get(1).toString());
                total_sales += totalSales;
            }
            input.close();
        System.out.println("\nTotal Sales: " + total_sales);
        }

    }

