package org.example.day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part2 {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources/day5/input.txt")));
        /*String input = "seeds: 79 14 55 13\n" +
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
                "56 93 4";*/

        long result = 0;
        List<Long> locations = new ArrayList<>();
        List<List<String>> seedsRange = saveSeeds2(input.split("\n")[0]);
        List<String> seeds;
        List<Long> value = new ArrayList<>();
        List<Map> soil = saveMap(input.split("\n"), "seed-to-soil map:");
        List<Map> fertilizer = saveMap(input.split("\n"), "soil-to-fertilizer map:");
        List<Map> water = saveMap(input.split("\n"), "fertilizer-to-water map:");
        List<Map> light = saveMap(input.split("\n"), "water-to-light map:");
        List<Map> temperature = saveMap(input.split("\n"), "light-to-temperature map:");
        List<Map> humidity = saveMap(input.split("\n"), "temperature-to-humidity map:");
        List<Map> location = saveMap(input.split("\n"), "humidity-to-location map:");
        // soil        | seeds  | range
        // destination | source | range
        // 50          | 98     | 2
        // 52          | 50     | 48
        for (List<String> seed : seedsRange) {
            value = createSeeds(seed, soil);
            /*seeds = findNumber2(seed, soil);
            seeds = findNumber2(seeds, fertilizer);
            seeds = findNumber2(seeds, water);
            seeds = findNumber2(seeds, light);
            seeds = findNumber2(seeds, temperature);
            seeds = findNumber2(seeds, humidity);
            seeds = findNumber2(seeds, location);

            List<Long> tmp = stringToLong(seeds);
            result = Collections.min(tmp);
            locations.add(result);*/
            int i = 1;
        }
//        result = Collections.min(locations);
        System.out.println(result);
    }

    private static List<Long> createSeeds(List<String> input, List<Map> map) {
        List<Long> result = new ArrayList<>();
        long start/* = Long.parseLong(input.get(0))*/;
        long end = Long.parseLong(input.get(1));
        long q = Long.parseLong(input.get(0)) + Long.parseLong(input.get(1));

        for (Map m : map) {
            start = m.source();
            end = (m.source() + m.range()) - 1;
            if (Long.parseLong(input.get(0)) + Long.parseLong(input.get(1)) < start) {
                continue;
            }
            while (start != end) {
                result.add(start++);
            }
        }

        return result;
    }

    private static List<List<String>> saveSeeds2(String seedsLine) {
        List<List<String>> result = new ArrayList<>();
        String[] seeds = seedsLine.split("\n")[0].split(":")[1].split(" ");
        seeds = Arrays.copyOfRange(seeds, 1, seeds.length);
        List<String> seedRange = new ArrayList<>();

        for (String seed : seeds) {
            if (seedRange.isEmpty()) {
                seedRange.add(seed);
            } else {
                seedRange.add(seed);
                result.add(seedRange);
                seedRange = new ArrayList<>();
            }
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

    private static List<String> findNumber2(List<String> seed, List<Map> map) {
        // start | range
        // 79    | 14
        // 79 - 92

        // 98    | 2
        // 98 - 99
        // 50    | 48
        // 50 - 97
        List<Map> mapCopy = new ArrayList<>(List.copyOf(map));
        List<String> result = new ArrayList<>();
        List<Long> seeds = new ArrayList<>();

        for (long i = Long.parseLong(seed.get(0)); i < Long.parseLong(seed.get(0)) + Long.parseLong(seed.get(1)); i++) {
            seeds.add(i);
        }

        for (Long elem : seeds) {
            for (Map mapLine : map) {
                long seedStart = Long.parseLong(seed.get(0));
                long seedEnd = seedStart + Long.parseLong(seed.get(1));
                long mapStart = mapLine.source();
                long mapEnd = (mapStart + mapLine.range()) - 1;
//                long seedCount = seedStart;

                if (mapStart <= elem && elem <= mapEnd) {
                    result.add(String.valueOf(mapLine.destination() + (elem - mapLine.source())));
                }
            }
        }

        /*for (Map mapLine : map) {
            long seedStart = Long.parseLong(seed.get(0));
            long seedEnd = seedStart + Long.parseLong(seed.get(1));
            long mapStart = mapLine.source();
            long mapEnd = (mapStart + mapLine.range()) - 1;
            long seedCount = seedStart;

            for (Long elem : seeds) {
                if (mapStart <= elem && elem <= mapEnd) {
                    result.add(String.valueOf(mapLine.destination() + (seedCount - mapLine.source())));
                }
            }*/

            /*if (seedStart >= mapStart && seedEnd <= mapEnd) {
                mapCopy.clear();
                mapCopy.add(new Map((mapLine.destination() + (seedCount - mapLine.source())), seedStart, mapLine.range()));
            } else {
                continue;
            }*/

            /*for (Map mapCopyLine : mapCopy) {
                if (mapCopyLine.source() <= seedCount && seedCount <= (mapCopyLine.source() + mapCopyLine.range()) - 1) {
                    result.add(String.valueOf(mapCopyLine.destination() + (seedCount - mapCopyLine.source())));
                    seedCount++;
                }
            }*/
//        } END FOR LOOP
        if (result.isEmpty()) {
            return seed;
        }

        return result;
    }

    private static List<Long> stringToLong(List<String> input) {
        List<Long> result = new ArrayList<>();
        for (String s : input) result.add(Long.parseLong(s));

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

    /*private static List<String[]> saveSeeds(String seedsLine) {
        List<String[]> result = new ArrayList<>();
        String[] seeds = seedsLine.split("\n")[0].split(":")[1].split(" ");
        seeds = Arrays.copyOfRange(seeds, 1, seeds.length);
        String[] seedRange = new String[2];

        for (String seed : seeds) {
            if (seedRange[0] == null) {
                seedRange[0] = seed;
            } else {
                seedRange[1] = seed;
                result.add(seedRange);
                seedRange = new String[2];
            }
        }

        return result;
    }*/

    /*private static List<Long> saveSeeds(String seedsLine) {
        List<Long> result = new ArrayList<>();
        List<String[]> newSeeds = new ArrayList<>();
        String[] seeds = seedsLine.split("\n")[0].split(":")[1].split(" ");
        seeds = Arrays.copyOfRange(seeds, 1, seeds.length);
        String[] seedRange = new String[2];
        System.err.println("First loop");
        for (String seed : seeds) {
            if (seedRange[0] == null) {
                seedRange[0] = seed;
            } else {
                seedRange[1] = seed;
                newSeeds.add(seedRange);
                seedRange = new String[2];
            }
        }
        System.err.println("Second loop");
        for (String[] seedArr : newSeeds) {
            long initialSeed = Long.parseLong(seedArr[0]);

            while (initialSeed != Long.parseLong(seedArr[0]) + Long.parseLong(seedArr[1])) {
                result.add(initialSeed);
                initialSeed++;
            }
        }
        System.err.println("Return from method");

        return result;
    }*/
}
