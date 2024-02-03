package org.example.day1;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class Part1 {
    public static void main(String[] args) throws IOException {
        String[] reader = {"1abc2",
                "pqr3stu8vwx",
                "a1b2c3d4e5f",
                "treb7uchet"};
        int result = 0;

        for (String e : reader) {
            Deque<String> arr = new LinkedList<>();
            for (byte b : e.getBytes()) {
                if (b >= 49 && b <= 57) {
                    arr.add(String.valueOf((char) b));
                }
            }
            result += Integer.parseInt(arr.getFirst() + arr.getLast());
        }
        System.out.println(result);
    }
}
