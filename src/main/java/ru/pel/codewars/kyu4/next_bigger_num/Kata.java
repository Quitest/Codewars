package ru.pel.codewars.kyu4.next_bigger_num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kata {
    private Kata() {
    }

    /**
     * Сложный, но все же интересный для реализации. Первоначально решение было достигнуто им.
     * Описание его приведено по <a href="https://dev.to/kopiro/kata-resolution-next-bigger-number-with-the-same-digits-41mj">ссылке</a>
     * @param n
     * @return
     */
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

    /**
     * Более простое и лаконичное решение задачи.
     * @param n
     * @return
     */
    public static long nextBiggerNumberSimple(long n)
    {
        char [] s = String.valueOf(n).toCharArray();
        for(int i = s.length - 2; i >= 0; i--){
            for (int j = s.length-1; j > i; j--){
                if(s[i] < s[j]){
                    char tmp = s[i];
                    s[i] = s[j];
                    s[j] = tmp;
                    Arrays.sort(s, i+1, s.length);
                    return Long.parseLong(String.valueOf(s));
                }
            }
        }
        return -1;
    }
}
