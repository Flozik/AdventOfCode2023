package org.example.day3;

import java.io.IOException;

public class Part1 {
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
        int result = 0, end = 0, start;
        char[][] grid = fillGrid(reader);
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
                    if (i == 0 && j == 0) { // left-top
                        if (!".".equals(String.valueOf(grid[i][end + 1]))) { // end right
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][end + 1]))) { // end right-bottom
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][end]))) { // end bottom
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][end - 1]))) { // end bottom-left
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[start + 1][start + 1]))) { // start bottom-right
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[start + 1][start]))) { // start bottom
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else {
                            number = new StringBuilder();
                        }
                    } else if (i == 0 && j == grid.length - 1) { // top-right
                        if (!".".equals(String.valueOf(grid[end + 1][end]))) { // end bottom
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][end - 1]))) { // end bottom-left
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[start + 1][start + 1]))) { // start right-bottom
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[start + 1][start]))) { // start bottom
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[start + 1][start - 1]))) { // start bottom left
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[start][start - 1]))) { // start left
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else {
                            number = new StringBuilder();
                            j = end + 1;
                        }
                    } else if (i == grid.length - 1 && j == grid.length - 1) { // right-bottom
                        if (!".".equals(String.valueOf(grid[end - 1][end - 1]))) { // end left-top
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[end - 1][end]))) { // end top
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[start][start - 1]))) { // start left
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[start - 1][start - 1]))) { // start left-top
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[start - 1][start]))) { // start top
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[start - 1][start + 1]))) { // start top-right
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else {
                            number = new StringBuilder();
                            j = end + 1;
                        }
                    } else if (j == 0 && i == grid.length - 1) { // bottom-left
                        if (!".".equals(String.valueOf(grid[end - 1][end - 1]))) { // end top-left
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[end - 1][end]))) { // end top
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[end - 1][end + 1]))) { // end top-right
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[end][end + 1]))) { // end right
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i - 1][start]))) { // start top
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][start + 1]))) { // start top-right
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else {
                            number = new StringBuilder();
                            j = end + 1;
                        }
                    } else if (j == 0) { // left
                        if (!".".equals(String.valueOf(grid[i - 1][end - 1]))) { // end left-top
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i - 1][end]))) { // end top
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i - 1][end + 1]))) { // end top-right
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i][end + 1]))) { // end right
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][end + 1]))) { // end right-bottom
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][end]))) { // end bottom
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][end - 1]))) { // end bottom-right
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i - 1][start]))) { // start top
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i - 1][start + 1]))) { // start top-right
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][start + 1]))) { // start right-bottom
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][start]))) { // start bottom
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else {
                            number = new StringBuilder();
                            j = end + 1;
                        }
                    } else if (i == 0) { // top
                        if (!".".equals(String.valueOf(grid[i][end + 1]))) { // end right
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][end + 1]))) { // end right-bottom
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][end]))) { // end bottom
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][end - 1]))) { // end bottom-left
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][start + 1]))) { // start bottom-right
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][start]))) { // start bottom
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][start - 1]))) { // start bottom-left
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i][start - 1]))) { // start left
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else {
                            number = new StringBuilder();
                            j = end + 1;
                        }
                    } else if (end == grid.length - 1) { // right
                        if (!".".equals(String.valueOf(grid[i - 1][end - 1]))) { // end left-top
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i - 1][end]))) { // end top
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][end]))) { // end bottom
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end;
                        } else if (!".".equals(String.valueOf(grid[i + 1][end - 1]))) { // end bottom-left
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i - 1][start - 1]))) { // start left-top
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i - 1][start]))) { // start top
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i - 1][start + 1]))) { // start top-right
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][start + 1]))) { // start right-bottom
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][start]))) { // start bottom
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][start - 1]))) { // start bottom-left
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i][start - 1]))) { // start left
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else {
                            number = new StringBuilder();
                            j = end + 1;
                        }
                    } else if (i == grid.length - 1) { // bottom
                        if (!".".equals(String.valueOf(grid[i - 1][end - 1]))) { // end left-top
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i - 1][end]))) { // end top
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i - 1][end + 1]))) { // end top-right
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i][end + 1]))) { // end right
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i][start - 1]))) { // start left
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i - 1][start - 1]))) { // start left-top
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i - 1][start]))) { // start top
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i - 1][start + 1]))) { // start top-right
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else {
                            number = new StringBuilder();
                            j = end + 1;
                        }
                    } else { // center
                        if (!".".equals(String.valueOf(grid[i - 1][end - 1]))) { // end left-top
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i - 1][end]))) { // end top
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i - 1][end + 1]))) { // end top-right
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i][end + 1]))) { // end right
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][end + 1]))) { // end right-bottom
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][end]))) { // end bottom
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][end - 1]))) { // end bottom-left
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i - 1][start - 1]))) { // start left-top
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i - 1][start]))) { // start top
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i - 1][start + 1]))) { // start top-right
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][start + 1]))) { // start right-bottom
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][start]))) { // start bottom
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i + 1][start - 1]))) { // start bottom-left
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else if (!".".equals(String.valueOf(grid[i][start - 1]))) { // start left
                            result += Integer.parseInt(number.toString());
                            number = new StringBuilder();
                            j = end + 1;
                        } else {
                            number = new StringBuilder();
                            j = end + 1;
                        }
                    }
                }
            }
        }
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
