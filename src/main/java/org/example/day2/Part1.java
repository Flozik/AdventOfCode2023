package org.example.day2;

import java.io.IOException;

public class Part1 {
    public static void main(String[] args) throws IOException {
        String[] reader = {"Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
                "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
                "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"};
        int result = 0, gameCounter = 0;

        for (String game : reader) {
            gameCounter++;
            boolean isGoodGame = true;
            int gameLength = game.length();

            game = game.substring(8, gameLength);

            String[] subsets = game.split(";");

            subsetsLoop:
            for (String subset : subsets) {
                String[] cubes = subset.split(",");
                for (String cube : cubes) {
                    cube = cube.replace(" ", "");
                    byte[] cubeBytes = cube.getBytes();
                    int sum = 0, red = 414, green = 629, blue = 525;

                    for (byte b : cubeBytes) {
                        sum += b;
                    }

                    if (cube.contains("red")) {
                        if (sum <= red) {
                        } else {
                            isGoodGame = false;
                            break subsetsLoop;
                        }
                    } else if (cube.contains("blue")) {
                        if (sum <= blue) {
                        } else {
                            isGoodGame = false;
                            break subsetsLoop;
                        }
                    } else if (cube.contains("green")) {
                        if (sum <= green) {
                        } else {
                            isGoodGame = false;
                            break subsetsLoop;
                        }
                    }
                }
            }
            if (isGoodGame) {
                result += gameCounter;
            }
        }
        System.out.println(result);
    }
}
