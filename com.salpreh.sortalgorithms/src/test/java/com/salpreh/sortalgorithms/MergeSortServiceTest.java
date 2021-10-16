package com.salpreh.sortalgorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortServiceTest extends BaseSortServiceTest {


    public MergeSortService sortService = new MergeSortService();

    @Test
    public void testSort() {
        List<Integer> list = generateRandom(25, 1, 100);
        List<Integer> sList = sortService.sort(list);

        checkSortedAsc(sList);
    }
}