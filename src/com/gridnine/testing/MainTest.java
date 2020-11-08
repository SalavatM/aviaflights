package com.gridnine.testing;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MainTest {
    List<Flight> flights = FlightBuilder.createFlights();

    @Test
    public void whenGivenFlightsListThenFilteredList1() {
        int result = Main.checkFlights1(flights).size();
        assertThat(result, is(5));
    }

    @Test
    public void whenGivenFlightsListThenFilteredList2() {
        int result = Main.checkFlights2(flights).size();
        assertThat(result, is(5));
    }

    @Test
    public void whenGivenFlightsListThenFilteredList3() {
        int result = Main.checkFlights3(flights).size();
        assertThat(result, is(1));
    }
}