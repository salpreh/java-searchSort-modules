package com.salpreh.sortalgorithms;

import com.salpreh.sortsearch.ISortService;

import java.util.ArrayList;
import java.util.List;

public class MergeSortService implements ISortService {
    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> list) {
        if (list.size() < 2) return list;

        List<T> res = new ArrayList<>(list);
        sort(res, 0, res.size() - 1);

        return res;
    }

    public <T extends Comparable<T>> void sort(List<T> list, int lo, int hi) {
        if (lo >= hi) return;

        int mid = (lo + hi) / 2;
        sort(list, lo, mid);
        sort(list, mid + 1, hi);

        int i = lo;
        int j = mid + 1;
        List<T> aux = new ArrayList<>();
        while (i <= mid && j <= hi) {
            if (list.get(i).compareTo(list.get(j)) < 0) {
                aux.add(list.get(i++));
            } else {
                aux.add(list.get(j++));
            }
        }

        while (i <= mid) {
            aux.add(list.get(i++));
        }

        while (j <= hi) {
            aux.add(list.get(j++));
        }

        for(int k = 0; k <= hi - lo; k++) {
            list.set(k + lo, aux.get(k));
        }
    }

    @Override
    public String sortName() {
        return "Merge Sort";
    }
}
