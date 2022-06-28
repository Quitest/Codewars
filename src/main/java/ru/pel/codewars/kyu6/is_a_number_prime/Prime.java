package ru.pel.codewars.kyu6.is_a_number_prime;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prime {
    public static boolean isPrime(int num) {
        Map<Integer, Integer> primeNumbers = new HashMap<>(num);


        Map<Integer, Integer> map = IntStream.range(2, num + 1)
                .filter(number -> number % 2 != 0 &&
                        number % 3 != 0 &&
                        number % 5 != 0
                )
                .boxed()
                .collect(Collectors.toMap(Function.identity(), i -> i));
        primeNumbers.putAll(map);
        int lastPrime = 7;

        while (lastPrime <= num) {
            map = IntStream.range(lastPrime, num + 1)
                    .filter(number -> number % lastPrime == 0)
                    .boxed()
                    .collect(Collectors.toMap(Function.identity(), i -> i));

        }
        return false; //TODO
    }
}
