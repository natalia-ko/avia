package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class OverTwoHoursOnGround extends Filter {
    int millisInHour = 1000 * 60 * 60;

    String rule = "общее время, проведённое на земле, превышает два часа";
//                 время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним

    @Override
    public List<Flight> filter(List<Flight> flights) {
        this.setRule(rule);

        List<Flight> result = super.filter(flights);

        return result;
    }


    @Override
    public boolean checkFlight(Flight flight) {
        List<Segment> segments = flight.getSegments();
        if (segments.size() < 2) {
            return false;
        } else {
            long groundTimeMillis = 0;
            for (int i = 0; i < segments.size() - 1; i++) {
                LocalDateTime arrivalOfPrevious = segments.get(i).getArrivalDate();
                LocalDateTime departureOfNext = segments.get(i + 1).getDepartureDate();
                groundTimeMillis += arrivalOfPrevious.until(departureOfNext, ChronoUnit.MILLIS);
            }
            return groundTimeMillis / millisInHour > 2;
        }
    }
}