package com.salpreh.sortalgorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

public class QuickSortServiceTest extends BaseSortServiceTest {

    public QuickSortService sortService = new QuickSortService();

    @Test
    public void testSort() {
        List<Integer> list = generateRandom(25, 1, 100);
        List<Integer> sList = sortService.sort(list);

        checkSortedAsc(sList);
    }
}
