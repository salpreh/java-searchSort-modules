package com.salpreh.mainappmodule;

import com.salpreh.sortsearch.ISearchService;
import com.salpreh.sortsearch.ISortService;
import com.salpreh.sortsearch.constants.SearchType;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        List<Integer> randList = generateRandom(100, 0, 100);
        List<Integer> scrambledList = generateScrambled(100);
        List<Integer> sortedList = generateSorted(0, 100);

        getSortServices().forEach(s -> printSortResults(s, randList, scrambledList));
        getSearchServices().forEach(s -> printSearchResults(s, SearchType.SORTED.equals(s.sortType()) ? sortedList : scrambledList));
    }

    private static void printSortResults(ISortService sortService, List<Integer> randList, List<Integer> scrambledList) {

        Instant i = Instant.now();
        System.out.println("SORT ALGORITHM: " + sortService.sortName());
        System.out.println("--------------------------------------------");
        System.out.println("Random list (with repetitions): " + randList);
        System.out.println("============================================");
        System.out.println("Sorted list: " + sortService.sort(randList));
        System.out.println("Time: " + Duration.between(i, Instant.now()).toMillis() / 1000.0 + "s");
        System.out.println("\n============================================");

        i = Instant.now();
        System.out.println("Scrambled list (no repetitions): " + scrambledList);
        System.out.println("============================================");
        System.out.println("Sorted list: " + sortService.sort(scrambledList));
        System.out.println("Time: " + Duration.between(i, Instant.now()).toMillis() / 1000.0 + "s");
        System.out.println("\n____________________________________________\n");
    }

    private static void printSearchResults(ISearchService searchService, List<Integer> list) {

        Instant i = Instant.now();
        System.out.println("SEARCH ALGORITHM: " + searchService.searchName() + " [" + searchService.sortType() + "]");
        System.out.println("List: " + list);
        System.out.println("--------------------------------------------");
        System.out.println("First elem: " + list.get(0));
        System.out.println("Result: " + searchService.search(list, list.get(0)));
        System.out.println("Time: " + Duration.between(i, Instant.now()).toMillis() / 1000.0 + "s");
        System.out.println("============================================");

        i = Instant.now();
        System.out.println("Last elem: " + list.get(list.size() - 1));
        System.out.println("Result: " + searchService.search(list, list.get(list.size() - 1)));
        System.out.println("Time: " + Duration.between(i, Instant.now()).toMillis() / 1000.0 + "s");
        System.out.println("============================================");

        i = Instant.now();
        int rndIdx = new Random().nextInt(0, list.size());
        System.out.println("Rand elem: " + list.get(rndIdx));
        System.out.println("Result: " + searchService.search(list, list.get(rndIdx)));
        System.out.println("Time: " + Duration.between(i, Instant.now()).toMillis() / 1000.0 + "s");
        System.out.println("============================================");

        System.out.println("\n____________________________________________\n");

    }

    private static Stream<ISortService> getSortServices() {
        return ServiceLoader.load(ISortService.class)
            .stream()
            .map(ServiceLoader.Provider::get);
    }

    private static Stream<ISearchService> getSearchServices() {
        return ServiceLoader.load(ISearchService.class)
            .stream()
            .map(ServiceLoader.Provider::get);
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

    private static List<Integer> generateSorted(int start, int end) {
        return IntStream.range(start, end + 1)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    private static List<Integer> generateRandom(int size, int min, int max) {
        Random rnd = new Random();
        return IntStream.range(0, size)
            .mapToObj(i -> rnd.nextInt(min, max))
            .collect(Collectors.toList());
    }
}
