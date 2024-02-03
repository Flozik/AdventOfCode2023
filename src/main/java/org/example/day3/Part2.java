package org.example.day3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part2 {
    public static void main(String[] args) throws IOException {
        String[] reader = {"467..114..",
                "...*......",
                "..35..633.",
                "......#...",
                "617*......",
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....",
                ".664.598.."};
        int result, end = 0, start;
        char[][] grid = fillGrid(reader);
        Map<String[], Integer> numberAndPlace = new HashMap<>();
        List<Integer> numbers = new ArrayList<>();
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (Character.isDigit(grid[i][j])) {
                    start = j;
                    number.append(grid[i][j]);
                    for (int k = j + 1; k < grid.length + 1; k++) {
                        if (k != grid.length && Character.isDigit(grid[i][k])) {
                            number.append(grid[i][k]);
                        } else {
                            end = k - 1;
                            break;
                        }
                    }
                    String[] coords = {start + "|" + i, end + "|" + i};
                    numberAndPlace.put(coords, Integer.valueOf(number.toString()));
                    number = new StringBuilder();
                    j = end + 1;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (String.valueOf(grid[i][j]).contains("*")) {
                    int n = 0;
                    int firstNumber = 0;
                    int secondNumber = 0;
                    if (Character.isDigit(grid[i - 1][j - 1])) {
                        String key = (j - 1) + "|" + (i - 1);
                        for (String[] k : numberAndPlace.keySet()) {
                            for (String e : k) {
                                if (e.equals(key)) {
                                    firstNumber = numberAndPlace.get(k);
                                    n++;
                                }
                            }
                        }
                    }
                    if (Character.isDigit(grid[i - 1][j])) {
                        String key = j + "|" + (i - 1);
                        if (firstNumber == 0) {
                            for (String[] k : numberAndPlace.keySet()) {
                                for (String e : k) {
                                    if (e.equals(key) && firstNumber == 0) {
                                        firstNumber = numberAndPlace.get(k);
                                        n++;
                                    } else if (e.equals(key) && secondNumber == 0 && !numberAndPlace.get(k).equals(firstNumber)) {
                                        secondNumber = numberAndPlace.get(k);
                                        n++;
                                    }
                                }
                            }
                        }
                    }
                    if (Character.isDigit(grid[i - 1][j + 1])) {
                        String key = (j + 1) + "|" + (i - 1);
                        if (secondNumber == 0) {
                            for (String[] k : numberAndPlace.keySet()) {
                                for (String e : k) {
                                    if (e.equals(key) && firstNumber == 0) {
                                        firstNumber = numberAndPlace.get(k);
                                        n++;
                                    } else if (e.equals(key) && secondNumber == 0 && !numberAndPlace.get(k).equals(firstNumber)) {
                                        secondNumber = numberAndPlace.get(k);
                                        n++;
                                    }
                                }
                            }
                        }
                    }
                    if (Character.isDigit(grid[i][j + 1])) {
                        String key = (j + 1) + "|" + i;
                        if (secondNumber == 0) {
                            for (String[] k : numberAndPlace.keySet()) {
                                for (String e : k) {
                                    if (e.equals(key) && firstNumber == 0) {
                                        firstNumber = numberAndPlace.get(k);
                                        n++;
                                    } else if (e.equals(key) && secondNumber == 0 && !numberAndPlace.get(k).equals(firstNumber)) {
                                        secondNumber = numberAndPlace.get(k);
                                        n++;
                                    }
                                }
                            }
                        }
                    }
                    if (Character.isDigit(grid[i + 1][j + 1])) {
                        String key = (j + 1) + "|" + (i + 1);
                        if (secondNumber == 0) {
                            for (String[] k : numberAndPlace.keySet()) {
                                for (String e : k) {
                                    if (e.equals(key) && firstNumber == 0) {
                                        firstNumber = numberAndPlace.get(k);
                                        n++;
                                    } else if (e.equals(key) && secondNumber == 0 && !numberAndPlace.get(k).equals(firstNumber)) {
                                        secondNumber = numberAndPlace.get(k);
                                        n++;
                                    }
                                }
                            }
                        }
                    }
                    if (Character.isDigit(grid[i + 1][j])) {
                        String key = j + "|" + (i + 1);
                        if (secondNumber == 0) {
                            for (String[] k : numberAndPlace.keySet()) {
                                for (String e : k) {
                                    if (e.equals(key) && firstNumber == 0) {
                                        firstNumber = numberAndPlace.get(k);
                                        n++;
                                    } else if (e.equals(key) && secondNumber == 0 && !numberAndPlace.get(k).equals(firstNumber)) {
                                        secondNumber = numberAndPlace.get(k);
                                        n++;
                                    }
                                }
                            }
                        }
                    }
                    if (Character.isDigit(grid[i + 1][j - 1])) {
                        String key = (j - 1) + "|" + (i + 1);
                        if (secondNumber == 0) {
                            for (String[] k : numberAndPlace.keySet()) {
                                for (String e : k) {
                                    if (e.equals(key) && firstNumber == 0) {
                                        firstNumber = numberAndPlace.get(k);
                                        n++;
                                    } else if (e.equals(key) && secondNumber == 0 && !numberAndPlace.get(k).equals(firstNumber)) {
                                        secondNumber = numberAndPlace.get(k);
                                        n++;
                                    }
                                }
                            }
                        }
                    }
                    if (Character.isDigit(grid[i][j - 1])) {
                        String key = (j - 1) + "|" + i;
                        if (secondNumber == 0) {
                            for (String[] k : numberAndPlace.keySet()) {
                                for (String e : k) {
                                    if (e.equals(key) && firstNumber == 0) {
                                        firstNumber = numberAndPlace.get(k);
                                        n++;
                                    } else if (e.equals(key) && secondNumber == 0 && !numberAndPlace.get(k).equals(firstNumber)) {
                                        secondNumber = numberAndPlace.get(k);
                                        n++;
                                    }
                                }
                            }
                        }
                    }
                    if (firstNumber != 0 && secondNumber != 0) {
                        numbers.add(firstNumber * secondNumber);
                    }
                }
            }
        }
        result = numbers.stream().reduce(0, Integer::sum);
        System.out.println(result);
    }

    private static char[][] fillGrid(String[] lines) {
        char[][] result = new char[140][140];
        int i = 0;

        for (String line : lines) {
            int j = 0;
            for (char c : line.toCharArray()) {
                result[i][j] = c;
                j++;
            }
            i++;
        }

        return result;
    }
}
