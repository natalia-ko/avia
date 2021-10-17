package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public class DepartureBeforeNow extends Filter {

    String rule = "вылет до текущего момента времени";

    @Override
    public List<Flight> filter(List<Flight> flights) {
        this.setRule(rule);
        List<Flight> result = super.filter(flights);

        return result;
    }

    @Override
    public boolean checkSegment(Segment segment) {
        return !segment.getDepartureDate().isBefore(LocalDateTime.now());
    }

}