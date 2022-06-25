package ru.pel.codewars.kyu7.square_every_digit;

public class SquareDigit {
    public int squareDigits(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        StringBuilder str = new StringBuilder();
        while (n > 0) {
            str.insert(0, (n % 10) * (n % 10)); //Что бы не использовать Math.pow() с последующим преобразованием типов.
            n /= 10;
        }
        return Integer.parseInt(str.toString());
    }
}
