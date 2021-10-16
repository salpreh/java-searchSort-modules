module com.salpreh.searchalgorithms {
    requires com.salpreh.sortsearch;
    exports com.salpreh.searchalgorithms;
    provides com.salpreh.sortsearch.ISearchService with com.salpreh.searchalgorithms.BinarySearchService;
}