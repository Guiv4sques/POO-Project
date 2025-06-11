package com.mycompany.app.events;

import com.mycompany.app.participants.Participant;
import com.mycompany.app.events.Event;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Workshop extends Event {
    private String praticalActivities;
    
    public Workshop(String title, LocalDate date, String location, int capacity, String description, String modality, String praticalActivities) {
        super(title, date, location, capacity, description, modality);
        this.praticalActivities = praticalActivities;
}

 @Override
    public String getType() {
        return "Workshop";
    }

    @Override
    public boolean canParticipate(Participant p) {
        return true;
    }

    public String getPraticalActivities() {
        return praticalActivities;
    }

    @Override
    public String toString() {
        return super.toString() + "\\nPratical activity: " + praticalActivities;
    }
}