package ru.pel.codewars.kyu4.next_bigger_num;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kata {
    public static long nextBiggerNumber(long n) {
        if (n < 10) {
            return -1;
        }
        long src = n;
        //12 ==> 21
        //513 ==> 531
        //2017 ==> 2071
        List<Integer> digitSentence = new ArrayList<>();
//        int mod = Integer.MIN_VALUE;
        while (n != 0) {
            int digit = (int) n % 10;
            digitSentence.add(0, digit); //с точки зрения производительности решение так себе.
            n = n / 10;
        }
        List<Integer> leftSubList = new ArrayList<>();
        for (int i = digitSentence.size() - 1; i >= 0; i--) {
            int curr = digitSentence.get(i);
            int next = digitSentence.get(i - 1);
            if (curr > next) {
                digitSentence.set(i, next);
                digitSentence.set(i - 1, curr);

                List<Integer> rightSubList = digitSentence.subList(i, digitSentence.size());
                rightSubList.sort(Comparator.naturalOrder());
                leftSubList = digitSentence.subList(0, i);
                leftSubList.addAll(rightSubList);
                break;
            }
        }
        long nextBigger = toLong(leftSubList);

        return nextBigger == src ? -1 : nextBigger;
    }

    private static long toLong(List<? extends Number> list){
        return Long.parseLong(list.stream().map(i -> i + "").collect(Collectors.joining()));
    }

    private Kata() {
    }
}
