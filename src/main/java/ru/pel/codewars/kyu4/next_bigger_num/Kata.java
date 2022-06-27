package ru.pel.codewars.kyu4.next_bigger_num;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kata {
    private Kata() {
    }

    public static long nextBiggerNumber(long n) {
        if (n < 10) {
            return -1;
        }
        long src = n;
        List<Integer> digitSentence = new ArrayList<>();
        while (n != 0) {
            int digit = (int) (n % 10);
            digitSentence.add(0, digit); //с точки зрения производительности решение так себе.
            n = n / 10;
        }

        List<Integer> leftPart = new ArrayList<>();
        for (int i = digitSentence.size() - 1; i > 0; i--) {
            int curr = digitSentence.get(i);
            int delimiter = digitSentence.get(i - 1);
            if (curr > delimiter) {
                List<Integer> rightPart = digitSentence.subList(i, digitSentence.size());
                int substitute = findBiggerThanDelimiter(rightPart, delimiter);
                digitSentence.set(i - 1, substitute);
                rightPart.remove(Integer.valueOf(substitute));
                rightPart.add(delimiter);
                rightPart.sort(Comparator.naturalOrder());

                leftPart = digitSentence.subList(0, i);
                leftPart.addAll(rightPart);
                break;
            }
        }
        if (leftPart.isEmpty()) {
            return -1;
        } else {
        long nextBigger = toLong(leftPart);
        return nextBigger == src ? -1 : nextBigger;
        }
    }

    private static long toLong(List<? extends Number> list) {
        return Long.parseLong(list.stream().map(i -> i + "").collect(Collectors.joining()));
    }

    private static int findBiggerThanDelimiter(List<Integer> part, Integer delimiter) {
        return part.stream().sorted().filter(digit -> digit > delimiter).findFirst().orElse(-1);
    }
}
