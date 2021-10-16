package com.salpreh.sortsearch;

import java.util.List;

public interface ISortService {
    <T extends Comparable<T>> List<T> sort(List<T> list);
    String sortName();
}
