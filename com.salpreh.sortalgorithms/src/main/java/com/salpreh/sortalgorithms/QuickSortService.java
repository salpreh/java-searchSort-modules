package com.salpreh.sortalgorithms;

import com.salpreh.sortsearch.ISortService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSortService implements ISortService {

    private Random random;

    public QuickSortService() {
        this.random = new Random();
    }

    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> list) {
        if (list.size() < 2) {
            return list;
        }
        List<T> res = new ArrayList<>(list);
        sort(res, 0, res.size() - 1);

        return res;
    }

    @Override
    public String sortName() {
        return "Quick Sort";
    }

    private <T extends Comparable<T>> void sort(List<T> list, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        // chose pivot
        int pivIdx = (hi + lo) / 2;
        T piv = list.get(pivIdx);

        // Sort
        int i = lo;
        int j = hi;
        while (true) {
            while (list.get(i).compareTo(piv) < 0) i++;
            while (list.get(j).compareTo(piv) > 0) j--;

            if (i >= j) break;

            swap(list, i, j);
            i++;
            j--;
        }

        sort(list, lo, j);
        sort(list, j+1, hi);
    }

    private <T extends Comparable<T>> void swap(List<T> list, int i1, int i2) {
        T el = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, el);
    }

    private <T extends Comparable<T>> int chosePivot(List<T> list) {
        if (list.isEmpty()) {
            throw new RuntimeException("No elements in list");
        }

        if (list.size() <= 2) return 0;

        int idx1 = random.nextInt(list.size());
        int idx2 = random.nextInt(list.size());
        int idx3 = random.nextInt(list.size());

        T i1 = list.get(idx1);
        T i2 = list.get(idx2);
        T i3 = list.get(idx3);

        if (i1.compareTo(i2) >= 0) {
            if (i1.compareTo(i3) <= 0) return idx1; // i1 between i2 and i3

            if (i3.compareTo(i2) >= 0) return idx3; // i3 between i2 and i1
            else return idx2; // i2 between i3 and i1
        } else {
            if (i1.compareTo(i3) >= 0) return idx1; // i1 between i3 and i2

            if (i3.compareTo(i2) <= 0) return idx3; // i3 between i2 and i1
            else return idx2; // i2 between i1 and i3
        }
    }
}
