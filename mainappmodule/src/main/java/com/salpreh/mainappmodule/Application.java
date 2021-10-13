package com.salpreh.mainappmodule;

import com.salpreh.sortmodule.ISortService;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        List<Integer> list = generateRandom(50, 0, 100);
        ISortService sortService = getSortService();
        Instant i = Instant.now();
        System.out.println("Random list (with repetitions): " + list);
        System.out.println("============================================");
        System.out.println("Sorted list: " + sortService.sort(list));
        System.out.println("Time: " + Duration.between(i, Instant.now()).toMillis() / 1000.0 + "s");
        System.out.println("\n============================================");

        list = generateScrambled(50);
        i = Instant.now();
        System.out.println("Scrambled list (no repetitions): " + list);
        System.out.println("============================================");
        System.out.println("Sorted list: " + sortService.sort(list));
        System.out.println("Time: " + Duration.between(i, Instant.now()).toMillis() / 1000.0 + "s");
    }

    private static ISortService getSortService() {
        return ServiceLoader.load(ISortService.class)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Unable to find instance of " + ISortService.class));
    }

    private static List<Integer> generateScrambled(int size) {
        Random rnd = new Random();
        List<Integer> list = IntStream.range(0, size)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        IntStream.range(0, size).forEach(i -> {
            int i1 = rnd.nextInt(size);
            int i2 = rnd.nextInt(size);

            Integer el = list.get(i1);
            list.set(i1, list.get(i2));
            list.set(i2, el);
        });

        return list;
    }

    private static List<Integer> generateRandom(int size, int min, int max) {
        Random rnd = new Random();
        return IntStream.range(0, size)
            .mapToObj(i -> rnd.nextInt(min, max))
            .collect(Collectors.toList());
    }
}
