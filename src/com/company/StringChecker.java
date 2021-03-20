package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StringChecker {
    //method for counting square brackets
    //method for checking that after number always are brackets
    //method for checking there are only numbers, latin letters and brackets
    private String s;

    public StringChecker(String s) {
        this.s = s;
    }

    public boolean Check() {
        return CountingBrackets() && NumberBeforeBrackets();
    }

    public boolean CountingBrackets() {
        char[] array = s.toCharArray();
        int open = 0;
        int close = 0;
        for (char a : array)
            if (a == '[') open++;
            else if (a == ']') close++;
        if (open - close != 0) {
            System.out.println("You should have the same amount of opening and closing brackets!");
            return false;
        } else return true;
    }

    public boolean NumberBeforeBrackets() {
        boolean a = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                for (int j = i - 1; j >= 0; j--) {
                    if (Character.isDigit(s.charAt(j))) break;
                    else a = false;
                }
            }
        }
        if (a == false) System.out.println("You should put numbers only before opening brackets!");
        return a;
    }
}
