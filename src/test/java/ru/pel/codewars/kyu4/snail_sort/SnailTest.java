package ru.pel.codewars.kyu4.snail_sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

class SnailTest {
    @Test
    void SnailTest1() {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[] r = {1, 2, 3, 6, 9, 8, 7, 4, 5};
        test(array, r);
    }

    public String int2dToString(int[][] a) {
        return Arrays.stream(a).map(Arrays::toString).collect(joining("\n"));
    }

    @Test
    void rotateAndCutTest() {
        int[][] array = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}};
        int[][] ints = Snail.rotateAndCut(array);
        Assertions.assertEquals("[[4, 5], [9, 6], [8, 7]]", Arrays.deepToString(ints));
    }

    public void test(int[][] array, int[] result) {
        String text = int2dToString(array) + " should be sorted to " + Arrays.toString(result);
        System.out.println(text);
        Assertions.assertArrayEquals(result, Snail.snail(array));
    }

    @Test
    void empty2DArrayTest(){
//        [[]] should be sorted to []
        int[][] array = {{}};
        int[] expected = new int[]{};
        Assertions.assertArrayEquals(expected, Snail.snail(array));
    }
}