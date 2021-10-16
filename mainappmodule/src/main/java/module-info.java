module com.salpreh.mainappmodule {
    requires com.salpreh.sortsearch;
    requires com.salpreh.sortalgorithms;
    requires com.salpreh.searchalgorithms;

    uses com.salpreh.sortsearch.ISortService;
    uses com.salpreh.sortsearch.ISearchService;
}