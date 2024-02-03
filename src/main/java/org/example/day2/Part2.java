package org.example.day2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Part2 {
    public static void main(String[] args) throws IOException {
        String[] reader = {"Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
                "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
                "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"};
        int result = 0, gameCounter = 0;

        for (String game : reader) {
            gameCounter++;
            int maxRedCube, maxGreenCube, maxBlueCube;
            int gameLength = game.length(), multipleResult = 0, subsetsCounter = 1;
            List<Integer> reds = new ArrayList<>(), greens = new ArrayList<>(), blues = new ArrayList<>();

            game = gameCounter != 100 ? game.substring(8, gameLength) : game.substring(9, gameLength);

            String[] subsets = game.split(";");

            for (String subset : subsets) {
                String[] cubes = subset.split(",");
                int cubesCounter = 1;
                for (String cube : cubes) {
                    cube = cube.replace(" ", "");
                    StringBuilder tmpNumber = new StringBuilder();
                    char firstChar = cube.charAt(0), secondChar = cube.charAt(1);

                    if (Character.isDigit(firstChar)) {
                        if (Character.isDigit(secondChar)) {
                            tmpNumber.append((int) firstChar - '0');
                            tmpNumber.append((int) secondChar - '0');
                        } else {
                            tmpNumber.append(firstChar);
                        }
                    }

                    int currentNumber = Integer.parseInt(tmpNumber.toString());
                    if (cube.contains("red")) {
                        reds.add(currentNumber);
                    } else if (cube.contains("green")) {
                        greens.add(currentNumber);
                    } else if (cube.contains("blue")) {
                        blues.add(currentNumber);
                    }

                    if (subsets.length == subsetsCounter && cubes.length == cubesCounter) {
                        Optional<Integer> opRed = reds.stream().max(Comparator.comparingInt(n -> n));
                        Optional<Integer> opGreen = greens.stream().max(Comparator.comparingInt(n -> n));
                        Optional<Integer> opBlue = blues.stream().max(Comparator.comparingInt(n -> n));

                        maxRedCube = opRed.orElse(0);
                        maxGreenCube = opGreen.orElse(0);
                        maxBlueCube = opBlue.orElse(0);

                        multipleResult = maxRedCube * maxGreenCube * maxBlueCube;
                        subsetsCounter = 1;
                    }
                    cubesCounter++;
                }
                subsetsCounter++;
            }
            result += multipleResult;
        }
        System.out.println(result);
    }
}
