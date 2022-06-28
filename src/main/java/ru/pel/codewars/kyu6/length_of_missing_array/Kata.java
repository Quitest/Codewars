package ru.pel.codewars.kyu6.length_of_missing_array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Kata {
    private Kata() {
    }
    /*Ну, нравится мне пользоваться Stream API :) Пока не наиграюсь, буду везде их применять. */
    public static int getLengthOfMissingArray(Object[][] arrayOfArrays) {
        if (arrayOfArrays == null || arrayOfArrays.length == 0) {
            return 0;
        }
        for (Object[] o : arrayOfArrays) {
            if (o == null || o.length == 0) {
                return 0;
            }
        }

        List<Integer> lengthOfArrays = Arrays.stream(arrayOfArrays)
                .map(row -> row.length)
                .sorted()
                .collect(Collectors.toList());

        int minimalRowLength = lengthOfArrays.get(0);
        int maximalRowLength = lengthOfArrays.get(lengthOfArrays.size() - 1) + 1;
        IntStream range = IntStream.range(minimalRowLength, maximalRowLength);

        return Stream.of(range, lengthOfArrays.stream().mapToInt(i -> i))
                .flatMapToInt(i -> i)
                .reduce(0, (result, rowLength) -> result ^= rowLength);
    }

    public static int getLengthOfMissingArrayAlternative(Object[][] arrayOfArrays) {
        if (arrayOfArrays == null || arrayOfArrays.length == 0) {
            return 0;
        }

        for (Object[] o : arrayOfArrays) {
            if (o == null || o.length == 0) {
                return 0;
            }
        }

        Arrays.sort(arrayOfArrays, Comparator.comparingInt(a -> a.length));

        for (int i = 0; i < arrayOfArrays.length - 1; i++) {
            if (arrayOfArrays[i].length != arrayOfArrays[i + 1].length - 1) {
                return arrayOfArrays[i].length + 1;
            }
        }
        return 0;
    }
}