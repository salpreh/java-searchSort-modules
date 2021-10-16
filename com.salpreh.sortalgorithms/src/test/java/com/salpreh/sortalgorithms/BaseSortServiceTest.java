package com.salpreh.sortalgorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class BaseSortServiceTest {

    protected <T extends Comparable<T>> void checkSortedAsc(List<T> list) {
        T lastItem = list.get(0);
        for (T item : list) {
            if (lastItem.compareTo(item) > 0){
                fail(lastItem + " greater than " + item);
            }
            lastItem = item;
        }
    }

    protected List<Integer> generateScrambled(int size) {
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

    protected List<Integer> generateRandom(int size, int min, int max) {
        Random rnd = new Random();
        return IntStream.range(0, size)
            .mapToObj(i -> rnd.nextInt(min, max))
            .collect(Collectors.toList());
    }
}
