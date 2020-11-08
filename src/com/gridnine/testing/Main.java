package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        // 1. вылет до текущего момента времени
        checkFlights1(flights);

        // 2. имеются сегменты с датой прилёта раньше даты вылета
        checkFlights2(flights);

        // 3. общее время, проведённое на земле, превышает два часа
        checkFlights3(flights);
    }

    public static List<Flight> checkFlights1(List<Flight> flights) {
        System.out.println("Список 1: исключены перелеты с вылетами до текущего момента времени");
        List<Flight> filteredList = new ArrayList<>();
        int count = 0;
        for (Flight flight : flights) {
            boolean correctFlight = true;
            List<Segment> segs = flight.getSegments();

            for (Segment seg : segs) {
                if (seg.getDepartureDate().isBefore(LocalDateTime.now())) {
                    correctFlight = false;
                    break;
                }
            }
            if (correctFlight) {
                filteredList.add(flight);
                count++;
                System.out.println("Flight " + count + ": " + flight);
            }
        }
        System.out.println();
        return filteredList;
    }

    public static List<Flight> checkFlights2(List<Flight> flights) {
        System.out.println("Список 2: исключены перелеты с датой прилёта раньше даты вылета");
        List<Flight> filteredList = new ArrayList<>();
        int count = 0;
        for (Flight flight : flights) {
            boolean correctFlight = true;
            List<Segment> segs = flight.getSegments();
            for (Segment seg : segs) {
                if (seg.getDepartureDate().isAfter(seg.getArrivalDate())) {
                    correctFlight = false;
                    break;
                }
            }
            if (correctFlight) {
                filteredList.add(flight);
                count++;
                System.out.println("Flight " + count + ": " + flight);
            }
        }
        System.out.println();
        return filteredList;
    }

    public static List<Flight> checkFlights3(List<Flight> flights) {
        System.out.println("Список 3: исключены перелеты с интервалом между сегментами более 2 часов");
        List<Flight> filteredList = new ArrayList<>();
        int groundTime = 0;
        int count = 0;
        for (Flight flight : flights) {
            boolean correctFlight = true;
            List<Segment> segs = flight.getSegments();
            if (segs.size() > 1) {
                LocalDateTime PreviousArrivalDate = null;
                for (Segment seg : segs) {
                    long d1 = PreviousArrivalDate == null ? 0
                            : Math.abs(ChronoUnit.HOURS.between(PreviousArrivalDate, seg.getDepartureDate()));
                    groundTime += d1;
                    if (groundTime > 2) {
                        correctFlight = false;
                        break;
                    }
                    PreviousArrivalDate = seg.getArrivalDate();
                }
            } else {
                correctFlight = false;
            }
            if (correctFlight) {
                filteredList.add(flight);
                count++;
                System.out.println("Flight " + count + ": " + flight);
            }
        }
        return filteredList;
    }
}

