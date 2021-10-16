import com.salpreh.sortalgorithms.MergeSortService;
import com.salpreh.sortalgorithms.QuickSortService;

module com.salpreh.sortalgorithms {
    requires com.salpreh.sortmodule;
    exports com.salpreh.sortalgorithms;
    provides com.salpreh.sortmodule.ISortService with QuickSortService, MergeSortService;
}