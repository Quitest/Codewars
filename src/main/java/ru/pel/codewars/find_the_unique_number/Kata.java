package ru.pel.codewars.find_the_unique_number;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Kata {
    public static double findUniq(double[] arr) {
        return Arrays.stream(arr).boxed().parallel()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElseThrow();
    }
}