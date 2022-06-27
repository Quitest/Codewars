package ru.pel.codewars.kyu4.next_bigger_num;

import java.util.ArrayList;
import java.util.Collections;
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
            digitSentence.add(0,digit); //с точки зрения производительности решение так себе.
            n = n / 10;
        }

        for (int i = digitSentence.size()-1; i >=0; i--) {
            int curr = digitSentence.get(i);
            int next = digitSentence.get(i - 1);
            if (curr > next) {
                digitSentence.set(i,next);
                digitSentence.set(i-1, curr);
                List<Integer> subList = digitSentence.subList(i, digitSentence.size() - 1);
                subList.sort(Comparator.reverseOrder());
//                digitSentence.re
                break;
            }
        }
        long nextBigger = Long.parseLong(digitSentence.stream().map(i->i+"").collect(Collectors.joining()));

        return nextBigger==src ? -1: nextBigger;
    }

    private boolean isBigger(int a, int b) {
        return a > b;
    }

    private Kata() {
    }
}
