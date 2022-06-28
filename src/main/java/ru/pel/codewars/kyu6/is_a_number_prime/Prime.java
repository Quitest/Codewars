package ru.pel.codewars.kyu6.is_a_number_prime;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prime {
    public static boolean isPrime(int num) {

        List<Integer> primeNumbers = IntStream.range(2, num + 1)
                .filter(number -> number % 2 != 0 &&
                        number % 3 != 0 &&
                        number % 5 != 0
                )
                .boxed().collect(Collectors.toCollection(LinkedList::new));
        int lastPrime = 7;

        while (lastPrime <= num) {
//            primeNumbers = primeNumbers.keySet().stream()
//                    .sorted()
//                    .filter(number -> number % lastPrime != 0)
////                    .boxed()
//                    .collect(Collectors.toMap(Function.identity(), i -> i));
        }
        return false; //TODO
    }
}
