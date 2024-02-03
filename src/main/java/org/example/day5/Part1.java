package org.example.day5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Part1 {
    public static void main(String[] args) throws IOException {
        String input = "seeds: 79 14 55 13\n" +
                "\n" +
                "seed-to-soil map:\n" +
                "50 98 2\n" +
                "52 50 48\n" +
                "\n" +
                "soil-to-fertilizer map:\n" +
                "0 15 37\n" +
                "37 52 2\n" +
                "39 0 15\n" +
                "\n" +
                "fertilizer-to-water map:\n" +
                "49 53 8\n" +
                "0 11 42\n" +
                "42 0 7\n" +
                "57 7 4\n" +
                "\n" +
                "water-to-light map:\n" +
                "88 18 7\n" +
                "18 25 70\n" +
                "\n" +
                "light-to-temperature map:\n" +
                "45 77 23\n" +
                "81 45 19\n" +
                "68 64 13\n" +
                "\n" +
                "temperature-to-humidity map:\n" +
                "0 69 1\n" +
                "1 0 69\n" +
                "\n" +
                "humidity-to-location map:\n" +
                "60 56 37\n" +
                "56 93 4";

        long result = 0;
        List<Long> locations = new ArrayList<>();
        List<Long> seeds = saveSeeds(input.split("\n")[0]);
        List<Map> soil = saveMap(input.split("\n"), "seed-to-soil map:");
        List<Map> fertilizer = saveMap(input.split("\n"), "soil-to-fertilizer map:");
        List<Map> water = saveMap(input.split("\n"), "fertilizer-to-water map:");
        List<Map> light = saveMap(input.split("\n"), "water-to-light map:");
        List<Map> temperature = saveMap(input.split("\n"), "light-to-temperature map:");
        List<Map> humidity = saveMap(input.split("\n"), "temperature-to-humidity map:");
        List<Map> location = saveMap(input.split("\n"), "humidity-to-location map:");

        for (Long seed : seeds) {
            result = findNumber(seed, soil);
            result = findNumber(result, fertilizer);
            result = findNumber(result, water);
            result = findNumber(result, light);
            result = findNumber(result, temperature);
            result = findNumber(result, humidity);
            result = findNumber(result, location);
            locations.add(result);
        }
        result = Collections.min(locations);
        System.out.println(result);
    }

    private static List<Long> saveSeeds(String seedsLine) {
        List<Long> result = new ArrayList<>();
        String[] seeds = seedsLine.split("\n")[0].split(":")[1].split(" ");
        seeds = Arrays.copyOfRange(seeds, 1, seeds.length);

        for (String seed : seeds) {
            result.add(Long.valueOf(seed));
        }

        return result;
    }

    private static List<Map> saveMap(String[] input, String mapType) {
        List<Map> result = new ArrayList<>();
        boolean isSameMap = false;

        for (String line : input) {
            if (line.equals(mapType)) {
                isSameMap = true;
                continue;
            }
            if (isSameMap) {
                if (line.isEmpty()) {
                    break;
                }
                String[] mapLine = line.split(" ");
                result.add(Map.of(Long.parseLong(mapLine[0]), Long.parseLong(mapLine[1]), Long.parseLong(mapLine[2])));
            }
        }

        return result;
    }

    private static long findNumber(long seed, List<Map> map) {
        long result = 0;
        for (Map mapLine : map) {
            if (mapLine.source() <= seed && seed <= (mapLine.source() + mapLine.range()) - 1) {
                result = mapLine.destination() + (seed - mapLine.source());
            }
        }
        if (result == 0) {
            return seed;
        }

        return result;
    }
}

record Map(long destination, long source, long range) {
    public static Map of(long destination, long source, long range) {
        return new Map(destination, source, range);
    }
}
