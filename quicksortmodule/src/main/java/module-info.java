module com.salpreh.quicksortmodule {
    requires com.salpreh.sortmodule;
    exports com.salpreh.quicksortmodule;
    provides com.salpreh.sortmodule.ISortService with com.salpreh.quicksortmodule.QSSortService;
}