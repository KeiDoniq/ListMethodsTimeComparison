package org.edu.vsu;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //TextTable
        StringBuilder s = new StringBuilder();
        s.append("-".repeat(80)).append('\n');
        s.append(String.format("%-20s%-40s%-40s%n","Method","LinkedList Time","ArrayList Time"));
        s.append("-".repeat(80)).append('\n');
        for(int i = 0; i < 10; ++i) {
            s.append(String.format("%-1s","method name")).append(
                    String.format("%20s%40s%n", "10", "20"));
            }
        System.out.println(s);
        System.out.println("Hello world!");
    }
}