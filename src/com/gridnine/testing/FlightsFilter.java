package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class FlightsFilter {

    List<Flight> filter(List<Flight> flights, List<Filter> filters){
        List<Flight> result = new ArrayList<>(flights);;
        for(Filter f : filters){
            result = f.filter(result);
        }
        return result;
    }
}
