package org.edu.vsu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Размерность списка:");
        ListMeasure listMeasure = new ListMeasure(input.nextInt());
        System.out.println(listMeasure.viewResTable());
    }
}