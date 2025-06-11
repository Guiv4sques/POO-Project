package com.mycompany.app.utils;

import com.mycompany.app.events.Event;
import com.mycompany.app.participants.Participant;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;

public class ReportUtil {

    public static void generateReportByType(List<Event> events) {
        Map<String, List<Event>> groupedByType = events.stream()
        .collect(Collectors.groupingBy(Event::getType));

        groupedByType.forEach((type, list) -> {
            System.out.println("\n=== Type events: " + type + " ===");
            list.forEach(e -> System.out.println(e.getTitle()));
        });
    }

    public static void generateReportByDate(List<Event> events) {
        events.stream()
                .sorted(Comparator.comparing(Event::getDate))
                .forEach(e -> System.out.println("\n[" + e.getDate() + "] " + e.getTitle()));
    }
}
