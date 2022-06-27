package ru.pel.codewars.kyu4.next_bigger_num;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KataTest {
    @Test
    void basicTests() {
        assertEquals(21, Kata.nextBiggerNumber(12));
        assertEquals(531, Kata.nextBiggerNumber(513));
        assertEquals(2071, Kata.nextBiggerNumber(2017));
        assertEquals(441, Kata.nextBiggerNumber(414));
        assertEquals(414, Kata.nextBiggerNumber(144));
        assertEquals(19009, Kata.nextBiggerNumber(10990));
    }
    @Test
    void simpleMethodTests() {
        assertEquals(21, Kata.nextBiggerNumberSimple(12));
        assertEquals(531, Kata.nextBiggerNumberSimple(513));
        assertEquals(2071, Kata.nextBiggerNumberSimple(2017));
        assertEquals(441, Kata.nextBiggerNumberSimple(414));
        assertEquals(414, Kata.nextBiggerNumberSimple(144));
        assertEquals(19009, Kata.nextBiggerNumberSimple(10990));
    }

    @Test
    void getDigitArray(){
        assertEquals(-1, Kata.nextBiggerNumber(10));
    }
}