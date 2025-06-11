package com.mycompany.app.events;

import com.mycompany.app.participants.Participant;
import com.mycompany.app.events.Event;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lecture extends Event {
    private String speaker;

    public Lecture(String title, LocalDate date, String location, int capacity, String description, String modality, String speaker) {
        super(title, date, location, capacity, description, modality);
        this.speaker = speaker;
    }

    @Override
    public String getType() {
        return "Lecture";
    }

    @Override
    public boolean canParticipate(Participant p) {
        return true;
    }

    public String getSpeaker() {
        return speaker;
    }

    @Override
    public String toString() {
        return super.toString() + "\\nSpeaker: " + speaker;
    }
}