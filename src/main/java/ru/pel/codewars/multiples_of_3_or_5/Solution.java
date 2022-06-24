package ru.pel.codewars.multiples_of_3_or_5;

import java.util.stream.IntStream;

public class Solution {
    public int solution(int number) {
        if (number <= 0) {
            return 0;
        }
        return IntStream.range(1, number)
                .filter(n -> (n % 3 == 0) || (n % 5 == 0))
                .reduce(0, Integer::sum);
    }
}
