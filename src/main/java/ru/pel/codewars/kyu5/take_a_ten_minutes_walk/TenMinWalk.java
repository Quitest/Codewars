package ru.pel.codewars.kyu5.take_a_ten_minutes_walk;

public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        if (walk.length != 10)
            return false;
        int horizontal = 0;
        int vertical = 0;
        for (char c : walk) {
            switch (c) {
                case 'n' -> vertical++;
                case 's' -> vertical--;
                case 'e' -> horizontal++;
                case 'w' -> horizontal--;
                default -> throw new IllegalArgumentException("Неизвестное направление");
            }
        }

        return horizontal == 0 && vertical == 0;
    }
}
