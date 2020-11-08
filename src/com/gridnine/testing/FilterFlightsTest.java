package com.gridnine.testing;

import org.junit.Test;
import java.util.List;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FilterFlightsTest {
    List<Flight> flights = FlightBuilder.createFlights();

    @Test
    public void whenGivenFlightsListThenFilteredList1() {
        List<Flight> expected = Main.checkFlights1(flights);
        List<Flight> result = FilterFlights.checkFlights(flights, seg -> seg.getDepartureDate().isAfter(LocalDateTime.now()));
        assertThat(result, is(expected));
    }

    @Test
    public void whenGivenFlightsListThenFilteredList2() {
        List<Flight> expected = Main.checkFlights2(flights);
        List<Flight> result = FilterFlights.checkFlights(flights, seg -> seg.getDepartureDate().isBefore(seg.getArrivalDate()));
        assertThat(result, is(expected));
    }

    @Test
    public void whenGivenFlightsListThenFilteredList3() {
        //List<Flight> expected = Main.checkFlights3(flights);
        //List<Flight> result = FilterFlights.checkFlights(flights, seg -> ...);
        int result = Main.checkFlights3(flights).size();
        int expected = 1;
        assertThat(result, is(expected));

    }
}