package com.gridnine.testing;

import java.util.List;

public class ArrivalBeforeDeparture extends Filter {

    String rule = "имеются сегменты с датой прилёта раньше даты вылета";

    @Override
    public List<Flight> filter(List<Flight> flights) {
        this.setRule(rule);
        List<Flight> result = super.filter(flights);

        return result;
    }

    @Override
    public boolean checkSegment(Segment segment) {
        return !segment.getArrivalDate().isBefore(segment.getDepartureDate());
    }

}
