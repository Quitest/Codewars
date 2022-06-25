package ru.pel.codewars.kyu6.find_the_odd_int;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindOdd {
    private FindOdd() {
    }

    public static int findIt(int[] a) {
        //Не уверен, что такая проверка даст существенный выигрыш. Хорошо бы замерить.
        if (a.length == 1) {
            return a[0];
        }

        return Arrays.stream(a).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .parallelStream()
                .filter(entry -> (entry.getValue() % 2) != 0)
                .findFirst().orElseThrow().getKey();
    }

    public static int findItXOR(int[] a) {
        int xor = 0;
        for (int j : a) {
            xor ^= j;
        }
        return xor;
    }
}
