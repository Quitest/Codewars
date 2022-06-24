package ru.pel.codewars.find_the_missing_letter;

public class Kata {
    /**
     * Метод поиска пропущенного символа. Арифметика делается с преобразованием char-int-char.
     * @param array массив символов, в котором происходит поиск пропущенного символа.
     * @return пропущенный символ. Если пропущенных символов нет, то символ пробела " ".
     */
    public static char findMissingLetter_int(char[] array) {
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
