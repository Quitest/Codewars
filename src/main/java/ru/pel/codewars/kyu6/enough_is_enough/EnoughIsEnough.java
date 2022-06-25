package ru.pel.codewars.kyu6.enough_is_enough;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnoughIsEnough {
    private EnoughIsEnough() {//скрываем публичный конструктор
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        List<Integer> array = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i : elements) {
            counter.compute(i, (k, v) -> (v == null) ? 0 : ++v);
            if (counter.get(i) < maxOccurrences) {
                array.add(i);
            }
        }
        return array.stream().mapToInt(i -> i).toArray();
    }
}
