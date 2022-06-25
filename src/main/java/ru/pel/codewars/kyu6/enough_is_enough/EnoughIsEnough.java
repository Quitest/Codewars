package ru.pel.codewars.kyu6.enough_is_enough;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

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

    public static int[] deleteNthVer2(int[] elements, int maxOccurrences){
        Map<Integer,Integer> occurrences = new HashMap<>();
        return IntStream.of(elements)
                .filter(element -> occurrences.merge(element,1, Integer::sum) <= maxOccurrences)
                .toArray();
    }
}
