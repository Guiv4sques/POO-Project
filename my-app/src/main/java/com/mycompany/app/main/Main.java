package com.mycompany.app.main;

import com.mycompany.app.events.Event;
import com.mycompany.app.events.Course;
import com.mycompany.app.events.Fair;
import com.mycompany.app.events.Lecture;
import com.mycompany.app.events.Workshop;
import com.mycompany.app.participants.Participant;
import com.mycompany.app.participants.Outsider;
import com.mycompany.app.participants.Student;
import com.mycompany.app.participants.Teacher;
import com.mycompany.app.utils.CertificateUtil;
import com.mycompany.app.utils.ReportUtil;

import java.time.LocalDate;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Event> events = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("===== ACADEMIC EVENTS MANAGER =====");

        while (true) {
            System.out.println("\n1. Create Event");
            System.out.println("2. Register Participant in Event");
            System.out.println("3. Generate Certificate");
            System.out.println("4. Report by Type");
            System.out.println("5. Report by Date");
            System.out.println("0. Exit");
            System.out.print("Choose an Option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> createEvent();
                case 2 -> registerParticipant();
                case 3 -> generateCertificate();
                case 4 -> ReportUtil.generateReportByType(events);
                case 5 -> ReportUtil.generateReportByDate(events);
                case 0 -> {
                    System.out.println("Closing...");
                    return;
                }
                default -> System.out.println("Invalid Option!");
            }
        }
    }

    private static void createEvent() {
        System.out.println("\nType of Event:");
        System.out.println("1. Course\n2. Workshop\n3. Fair\n4. Lecture");
        int type = Integer.parseInt(scanner.nextLine());

        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Date (AAAA-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.print("Location: ");
        String location = scanner.nextLine();
        System.out.print("Capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Modality (IN-PERSON, ONLINE, HYBRID): ");
        String modality = scanner.nextLine();

        Event event = null;
        switch (type) {
            case 1 -> {
                System.out.print("Workload: ");
                int load = Integer.parseInt(scanner.nextLine());
                event = new Course(title, date, location, capacity, description, modality, load);
            }
            case 2 -> {
                System.out.print("Pratical Activity: ");
                String activity = scanner.nextLine();
                event = new Workshop(title, date, location, capacity, description, modality, activity);
            }
            case 3 -> {
                System.out.print("Number of Stands: ");
                int stands = Integer.parseInt(scanner.nextLine());
                event = new Fair(title, date, location, capacity, description, modality, stands);
            }
            case 4 -> {
                System.out.print("Speaker: ");
                String speaker = scanner.nextLine();
                event = new Lecture(title, date, location, capacity, description, modality, speaker);
            }
            default -> System.out.println("Type invalid!");
        }

        if (event != null) {
            events.add(event);
            System.out.println("Event created successfully!");
        }
    }

    private static void registerParticipant() {
        if (events.isEmpty()) {
            System.out.println("No event registered!");
            return;
        }

        System.out.println("\nAvailable events:");
        for (int i = 0; i < events.size(); i++) {
            System.out.println((i + 1) + ". " + events.get(i).getTitle());
        }
        System.out.print("Choose the event number: ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        Event event = events.get(idx);

        System.out.println("\nType of Participant:");
        System.out.println("1. Student\n2. Teacher\n3. Outsider");
        int type = Integer.parseInt(scanner.nextLine());

        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Participant participant = null;
        switch (type) {
            case 1 -> {
                System.out.print("Registration: ");
                String registration = scanner.nextLine();
                System.out.print("Course: ");
                String course = scanner.nextLine();
                participant = new Student(name, email, registration, course);
            }
            case 2 -> {
                System.out.print("SIAPE: ");
                String siape = scanner.nextLine();
                System.out.print("Area of Activity: ");
                String area = scanner.nextLine();
                participant = new Teacher(name, email, siape, area);
            }
            case 3 -> {
                System.out.print("Institution: ");
                String inst = scanner.nextLine();
                System.out.print("Occupation: ");
                String occupation = scanner.nextLine();
                participant = new Outsider(name, email, inst, occupation);
            }
            default -> System.out.println("Type invalid!");
        }

        if (participant != null) {
            if (event.addParticipant(participant)) {
                System.out.println(participant.getName() + " successfully registered in " + event.getTitle());
            } else {
                System.out.println("Could not register " + participant.getName() + " in event: " + event.getTitle());
            }
        }
    }

    private static void generateCertificate() {
        for (Event e : events) {
            for (Participant p : e.getParticipants()) {
                CertificateUtil.generateCertificate(e, p);
            }
        }
        System.out.println("Certificates generates for all registeres participants.");
    }
}