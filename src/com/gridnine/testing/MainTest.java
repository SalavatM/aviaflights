package com.gridnine.testing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MainTest {
    FlightBuilder flightBuilder = new FlightBuilder();
    List<Flight> flights = flightBuilder.createFlights();

    @Test
    public void whenGivenFlightsListThenFilteredList1() {
        int result = Main.checkFlights1(flights);
        assertThat(result, is(5));
    }

    @Test
    public void whenGivenFlightsListThenFilteredList2() {
        int result = Main.checkFlights2(flights);
        assertThat(result, is(5));
    }

    @Test
    public void whenGivenFlightsListThenFilteredList3() {
        int result = Main.checkFlights2(flights);
        assertThat(result, is(5));
    }
}