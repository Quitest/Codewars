package ru.pel.codewars.kyu6.length_of_missing_array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KataTest {
    @Test
    void BasicTests() {
        assertEquals(3, Kata.getLengthOfMissingArray(new Object[][]{
                new Object[]{1, 2},
                new Object[]{4, 5, 1, 1},
                new Object[]{1},
                new Object[]{5, 6, 7, 8, 9}}));
        assertEquals(2, Kata.getLengthOfMissingArray(new Object[][]{
                new Object[]{5, 2, 9},
                new Object[]{4, 5, 1, 1},
                new Object[]{1},
                new Object[]{5, 6, 7, 8, 9}}));
        assertEquals(2, Kata.getLengthOfMissingArray(new Object[][]{
                new Object[]{null},
                new Object[]{null, null, null}}));
        assertEquals(5, Kata.getLengthOfMissingArray(new Object[][]{
                new Object[]{'a', 'a', 'a'},
                new Object[]{'a', 'a'},
                new Object[]{'a', 'a', 'a', 'a'},
                new Object[]{'a'},
                new Object[]{'a', 'a', 'a', 'a', 'a', 'a'}}));
        assertEquals(0, Kata.getLengthOfMissingArray(new Object[][]{}));
    }

    @Test
    void firstExtendedTest() {
        assertEquals(5, Kata.getLengthOfMissingArray(new Object[][]{
                new Object[]{2, 3, 0, 0, 1, 2},
                new Object[]{0, 0, 3, 4},
                new Object[]{0, 3, 3}}));
    }

    @Test
    @DisplayName("Массивы 4, 2, 5. Ожидается 3")
    void secondExtendedTest() {
        assertEquals(3, Kata.getLengthOfMissingArray(new Object[][]{
                new Object[]{4, 5, 1, 1},
                new Object[]{1, 2},
                new Object[]{5, 6, 7, 8, 9}}));
    }

    @Test
    @DisplayName("Массив содержит массив нулевой длинны. Ожидается 0")
    void thirdExtendedTest() {
        assertEquals(0, Kata.getLengthOfMissingArray(new Object[][]{
                new Object[]{4, 0, 3},
                new Object[]{1, 2},
                new Object[]{}}));
    }

    @Test
    @DisplayName("переадем NULL")
    void fourthExtendedTest(){
        assertEquals(0, Kata.getLengthOfMissingArray(null));
    }
}