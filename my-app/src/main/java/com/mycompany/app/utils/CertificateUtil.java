package com.mycompany.app.utils;

import com.mycompany.app.events.Event;
import com.mycompany.app.participants.Participant;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class CertificateUtil {

    public static void generateCertificate(Event event, Participant participant) {
        String content = "We certify that " + participant.getName() +
                " participated in the event \"" + event.getTitle() +
                "\" carried out in " + event.getDate() +
                ", in the modality " + event.getModality() + ".\n\n" +
                "Description: " + event.getDescription() + "\n\n" +
                "Organization: IFBA - Instituto Federal da Bahia";

        String fileName = "certificate_" + participant.getName().replaceAll(" ", "_") + ".txt";

        try {
            Files.write(Paths.get(fileName), content.getBytes());
            System.out.println("Generated certificate: " + fileName);
        } catch (IOException e) {
            System.err.println("Error generate certificate: " + e.getMessage());
        }
    }
}
