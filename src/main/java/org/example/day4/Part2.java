package org.example.day4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part2 {
    public static void main(String[] args) throws IOException {
        String[] reader = {"Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53",
                "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19",
                "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1",
                "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83",
                "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36",
                "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11"};
        int result;
        int stringCounter = 0;
        List<Integer> scratchcards = new ArrayList<>();
        Map<Integer, Integer> numberOfCards = new HashMap<>();
        for (int i = 0; i < reader.length; i++) {
            numberOfCards.put(i, 1);
        }

        for (String s : reader) {
            String[] winningNumbers = s.split(" ", 3)[2].split("\\|")[0].split(" ");
            String[] myNumbers = s.split(" ", 3)[2].split("\\|")[1].replace("  ", " ").split(" ");
            myNumbers = Arrays.copyOfRange(myNumbers, 1, myNumbers.length);
            int currentValue = numberOfCards.get(stringCounter);
            int element = stringCounter;

            for (String winningNumber : winningNumbers) {
                for (String myNumber : myNumbers) {
                    if (winningNumber.equals(myNumber)) {
                        numberOfCards.put(++element, numberOfCards.get(element) + currentValue);
                    }
                }
            }
            scratchcards.add(currentValue);
            stringCounter++;
        }
        result = scratchcards.stream().reduce(0, Integer::sum);
        System.out.println(result);
    }
}
