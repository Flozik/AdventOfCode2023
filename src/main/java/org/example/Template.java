package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Template {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day5/input.txt")));
//        String input = "";

        int result = 0;

        for (String s : input.split("")) {
            System.out.println(s);
        }
    }
}
