package ru.pel.codewars.kyu7.square_every_digit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareDigitTest {
    @Test
    void test() {
        assertEquals(811181, new SquareDigit().squareDigits(9119));
        assertEquals(0, new SquareDigit().squareDigits(0));
    }

    @Test
    void test2(){
        assertEquals(9414, new SquareDigit().squareDigits(3212) );
    }
    @Test
    void test3(){
        assertEquals(3625490, new SquareDigit().squareDigits(6570) );
    }
}