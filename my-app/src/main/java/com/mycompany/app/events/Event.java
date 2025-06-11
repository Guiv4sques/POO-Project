package com.mycompany.app.events;

import com.mycompany.app.participants.Participant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Event implements IEvent{
    protected String title;
    protected LocalDate date;
    protected String location;
    protected int capacity;
    protected String description;
    protected String modality;
    protected List<Participant> participants;

    public Event(String title, LocalDate date, String location, int capacity, String description, String modality) {
        this.title = title;
        this.date = date;
        this.location = location;
        this.capacity = capacity;
        this.description = description;
        this.modality = modality;
        this.participants = new ArrayList<>();
    }

    public boolean addParticipant(Participant p) {
        if (participants.size() < capacity && canParticipate(p)) {
            participants.add(p);
            return true;
        }
        return false;
    }

    public abstract String getType();

    public String getTitle() {
        return title;
    }

    public List<Participant> getParticipants() {
    return participants;
    }

      public LocalDate getDate () {
        return date;
    }

      public String getModality () {
        return modality;
    }

      public String getDescription () {
        return description;
    }
    public abstract boolean canParticipate(Participant p);
}