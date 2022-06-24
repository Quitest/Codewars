package ru.pel.codewars.kyu6.length_of_missing_array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Kata {
    private Kata() {
    }

    public static int getLengthOfMissingArray(Object[][] arrayOfArrays) {
        if (arrayOfArrays == null || arrayOfArrays.length == 0) {
            return 0;
        }



        int minLength = Arrays.stream(arrayOfArrays)
                .mapToInt(a -> a.length).min().getAsInt();//FIXME при онлайн тестах, предположительно тут вылетает NPE
        if (minLength == 0){
            return 0;
        }
        AtomicInteger lengthOfPrevArr = new AtomicInteger(minLength);

        return Arrays.stream(arrayOfArrays)
                .sorted(Comparator.comparing(arr -> arr.length, Comparator.naturalOrder()))
                .dropWhile(currArr -> {
                    boolean result = (currArr.length - lengthOfPrevArr.get()) < 2;
                    lengthOfPrevArr.set(currArr.length);
                    return result;
                })
                .findFirst().orElseThrow().length-1;
    }
}