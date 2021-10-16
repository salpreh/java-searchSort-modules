import com.salpreh.sortalgorithms.MergeSortService;
import com.salpreh.sortalgorithms.QuickSortService;

module com.salpreh.sortalgorithms {
    requires com.salpreh.sortsearch;
    exports com.salpreh.sortalgorithms;
    provides com.salpreh.sortsearch.ISortService with QuickSortService, MergeSortService;
}