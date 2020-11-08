package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterFlights {
    public static List<Flight> checkFlights(List<Flight> flights, Predicate<? super Segment> func) {
        List<Flight> res = new ArrayList<>();
        for (var flight : flights) {
            var segs = flight.getSegments().stream().filter(func).collect(Collectors.toList());
            if (segs.size() > 0) {
                res.add(flight);
            }
        }
        if (res.size() > 1) {
            System.out.println("Перелеты по заданному поисковому фильтру:");
            res.forEach(System.out::println);
        } else {
            System.out.println("Перелеты по заданному поисковому фильтру не найдены");
        }
        System.out.println();

        return res;
    }
}
