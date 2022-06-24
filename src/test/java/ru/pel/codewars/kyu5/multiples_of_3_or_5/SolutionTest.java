package ru.pel.codewars.kyu5.multiples_of_3_or_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void solution() {
        Assertions.assertEquals(23, new Solution().solution(10));
    }
}