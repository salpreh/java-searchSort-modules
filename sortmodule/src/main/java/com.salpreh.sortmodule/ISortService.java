package com.salpreh.sortmodule;

import java.util.List;

public interface ISortService {
    <T extends Comparable<T>> List<T> sort(List<T> list);
    String sortName();
}
