package com.salpreh.sortsearch;

import com.salpreh.sortsearch.constants.SearchType;

import java.util.List;

public interface ISearchService {
    <T extends Comparable<T>> Integer search(List<T> list, T item);
    String searchName();
    SearchType sortType();
}
