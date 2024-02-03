package org.example.day1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Part2 {
    public static void main(String[] args) throws IOException {
        String[] reader = {"two1nine",
                "eightwothree",
                "abcone2threexyz",
                "xtwone3four",
                "4nineeightseven2",
                "zoneight234",
                "7pqrstsixteen"};
        List<String> numbers = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        int result = 0;

        for (String e : reader) {
            Deque<String> stringNumbers = new LinkedList<>();
            char[] arrChar = e.toCharArray();
            List<String> tmpArrChar = new ArrayList<>(e.length());
            for (char c : arrChar) {
                if (Character.isDigit(c)) {
                    stringNumbers.add(String.valueOf(c));
                    continue;
                }
                if (tmpArrChar.isEmpty()) {
                    tmpArrChar.add(String.valueOf(c));
                    continue;
                } else {
                    tmpArrChar.set(0, tmpArrChar.get(0) + c);
                }

                if (tmpArrChar.get(0).contains(numbers.get(0))) {
                    stringNumbers.add("1");
                    tmpArrChar.set(0, tmpArrChar.get(0).replace("n", ""));
                } else if (tmpArrChar.get(0).contains(numbers.get(1))) {
                    stringNumbers.add("2");
                    tmpArrChar.set(0, tmpArrChar.get(0).replace("w", ""));
                } else if (tmpArrChar.get(0).contains(numbers.get(2))) {
                    stringNumbers.add("3");
                    tmpArrChar.set(0, tmpArrChar.get(0).replace("e", ""));
                } else if (tmpArrChar.get(0).contains(numbers.get(3))) {
                    stringNumbers.add("4");
                    tmpArrChar.set(0, tmpArrChar.get(0).replace("u", ""));
                } else if (tmpArrChar.get(0).contains(numbers.get(4))) {
                    stringNumbers.add("5");
                    tmpArrChar.set(0, tmpArrChar.get(0).replace("v", ""));
                } else if (tmpArrChar.get(0).contains(numbers.get(5))) {
                    stringNumbers.add("6");
                    tmpArrChar.set(0, tmpArrChar.get(0).replace("i", ""));
                } else if (tmpArrChar.get(0).contains(numbers.get(6))) {
                    stringNumbers.add("7");
                    tmpArrChar.set(0, tmpArrChar.get(0).replace("e", ""));
                } else if (tmpArrChar.get(0).contains(numbers.get(7))) {
                    stringNumbers.add("8");
                    tmpArrChar.set(0, tmpArrChar.get(0).replace("h", ""));
                } else if (tmpArrChar.get(0).contains(numbers.get(8))) {
                    stringNumbers.add("9");
                    tmpArrChar.set(0, tmpArrChar.get(0).replace("n", ""));
                }
            }
            result += Integer.parseInt(stringNumbers.getFirst() + stringNumbers.getLast());
        }
        System.out.println(result);
    }
}
