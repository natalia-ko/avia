package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class FilterManager {

    private List<Filter> filterList;

    public FilterManager() {
        filterList = new ArrayList<>();
    }

    public List<Filter> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<Filter> filterList) {
        this.filterList = filterList;
    }

    public boolean addFilter(Filter flightFilter) {
        return filterList.add(flightFilter);
    }

}
