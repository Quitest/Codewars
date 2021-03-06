package ru.pel.codewars.kyu5.find_the_missing_letter;

import java.util.NoSuchElementException;

public class Kata {
    private Kata() {//скрываем публичный конструктор
    }

    /**
     * Метод поиска пропущенного символа. Поиск делается с помощью свойств XOR.
     *
     * @param array массив символов, в котором происходит поиск пропущенного символа.
     * @return пропущенный символ. Если пропущенных символов нет, то символ пробела " ".
     * @throws NoSuchElementException если в последовательности присутствуют все символы.
     */
    public static char findMissingLetterXOR(char[] array) {
        char lastLetter = array[array.length - 1];
        char missedLetter = '\u0000';
        for (char s = array[0]; s <= lastLetter; s++) {
            missedLetter ^= s;
        }
        for (char s : array) {
            missedLetter ^= s;
        }

        if (missedLetter == '\u0000') {
            throw new NoSuchElementException("Пропущенные символы отсутствуют");
        }
        return missedLetter;
    }

    /**
     * Метод поиска пропущенного символа. Арифметика делается с преобразованием char-int-char.
     *
     * @param array массив символов, в котором происходит поиск пропущенного символа.
     * @return пропущенный символ. Если пропущенных символов нет, то символ пробела " ".
     */
    public static char findMissingLetterInt(char[] array) {
        int prev = array[0];
        int curr;
        for (int i = 1; i < array.length; i++) {
            curr = array[i];
            if (curr - prev > 1)
                return (char) (curr - 1);
            prev = curr;
        }
        return ' ';
    }

    /**
     * Метод поиска пропущенного символа. Арифметика делается с типом char (без явных преобразований).
     *
     * @param array массив символов, в котором происходит поиск пропущенного символа.
     * @return пропущенный символ. Если пропущенных символов нет, то символ пробела " ".
     */
    public static char findMissingLetter(char[] array) {
        char prevChar = array[0];
        for (char currChar : array) {
            if (currChar - prevChar > 1) {
                return --currChar;
            }
            prevChar = currChar;
        }
        return ' ';
    }
}
