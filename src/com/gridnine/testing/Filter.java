package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public abstract class Filter implements FlightCheck {

    private String rule;

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }


    @Override
    public boolean checkFlight(Flight flight) {
        List<Segment> segments = flight.getSegments();
        boolean result = true;
        for (Segment s : segments) {
            if (!checkSegment(s)) {
                result = false;
            }
        }
        return result;
    }

    boolean checkSegment(Segment segment) {
        return true;
    }

    public List<Flight> filter(List<Flight> flights) {
        List<Flight> result = new ArrayList<>();
        for (Flight f : flights) {
            if (checkFlight(f)) {
                result.add(f);
            }
        }
        System.out.println("Из тестового набора исключены следующие перелёты: " + rule);
        result.forEach(System.out::println);
        System.out.println();
        return result;
    }


}
