package com.salpreh.searchalgorithms;

import com.salpreh.sortsearch.ISearchService;
import com.salpreh.sortsearch.constants.SearchType;

import java.util.List;

public class BinarySearchService implements ISearchService {
    @Override
    public <T extends Comparable<T>> Integer search(List<T> list, T item) {
        return search(list, item, 0, list.size() - 1);
    }

    public <T extends Comparable<T>> Integer search(List<T> list, T item , int lo, int hi) {
        if (hi <= lo) {
            return list.get(lo).equals(item) ? lo : null;
        }

        int mid = (lo + hi) / 2;
        if (list.get(mid).compareTo(item) == 0) return mid;
        else if (list.get(mid).compareTo(item) > 0) return search(list, item, lo, mid);

        return search(list, item, mid, hi);
    }

    @Override
    public String searchName() {
        return "Binary Search";
    }

    @Override
    public SearchType sortType() {
        return SearchType.SORTED;
    }
}
