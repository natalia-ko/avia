package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();

        flights.forEach(System.out::println);
        System.out.println();

        FilterManager fm = new FilterManager();
        fm.addFilter(new DepartureBeforeNow());
        fm.addFilter(new ArrivalBeforeDeparture());
        fm.addFilter(new OverTwoHoursOnGround());

        FlightsFilter ff = new FlightsFilter();
        ff.filter(flights, fm.getFilterList());

    }
}
