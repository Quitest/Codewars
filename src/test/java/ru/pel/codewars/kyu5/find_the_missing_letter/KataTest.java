package ru.pel.codewars.kyu5.find_the_missing_letter;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class KataTest {
    @Test
    void exampleTests() {
        assertEquals('e', Kata.findMissingLetter(new char[]{'a', 'b', 'c', 'd', 'f'}));
        assertEquals('P', Kata.findMissingLetter(new char[]{'O', 'Q', 'R', 'S'}));
    }

    @Test
    void findMissingLetterInt() {
        assertEquals('e', Kata.findMissingLetterInt(new char[]{'a', 'b', 'c', 'd', 'f'}));
        assertEquals('P', Kata.findMissingLetterInt(new char[]{'O', 'Q', 'R', 'S'}));
    }

    @Test
    void findMissingLetterXOR() {
        assertThrowsExactly(NoSuchElementException.class, ()->Kata.findMissingLetterXOR(new char[]{'a', 'b', 'c', 'd', 'e', 'f'}));
        assertEquals('e', Kata.findMissingLetterXOR(new char[]{'a', 'b', 'c', 'd', 'f'}));
        assertEquals('P', Kata.findMissingLetterXOR(new char[]{'O', 'Q', 'R', 'S'}));
    }
}