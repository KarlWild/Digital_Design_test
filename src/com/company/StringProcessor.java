package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringProcessor {
    private StringBuilder sb;
    private String inputString;
    private StringBuilder numbers = new StringBuilder();

    public StringProcessor(String s) {
        sb = new StringBuilder();
        inputString = s;
    }

    public void Process() {
        int flag = 0;
        List<Integer> listNumber = new ArrayList<>();
        Map<Integer, StringBuilder> flagString = new HashMap<>();
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == '[') {
                flag++;
                listNumber.add(Integer.parseInt(numbers.toString()));
                numbers = new StringBuilder();
                flagString.put(flag, new StringBuilder());
            } else if (inputString.charAt(i) == ']' && flag != 0) {
                String s = flagString.get(flag).toString();
                int length = listNumber.get(listNumber.size() - 1);
                for (int j = 0; j < length - 1; j++)
                    flagString.get(flag).append(s);
                listNumber.remove(listNumber.size() - 1);
                flag--;
                if (flag != 0) flagString.get(flag).append(flagString.get(flag + 1));
                else sb.append(flagString.get(flag + 1));
                flagString.remove(flag + 1);
            } else if (Character.isDigit(inputString.charAt(i))) numbers.append(inputString.charAt(i));
            else if (flag == 0) sb.append(inputString.charAt(i));
            else flagString.get(flag).append(inputString.charAt(i));
        }
    }

    public StringBuilder getSb() {
        return sb;
    }
}
