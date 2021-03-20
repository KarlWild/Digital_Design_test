package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        String s = "";
        while (true) {
            System.out.println("Type the string:");
            s = sc.nextLine();
            StringChecker checker = new StringChecker(s);
            if (checker.Check()) break;
        }
        StringProcessor sp = new StringProcessor(s);
        sp.Process();
        System.out.println(sp.getSb());

    }
}
