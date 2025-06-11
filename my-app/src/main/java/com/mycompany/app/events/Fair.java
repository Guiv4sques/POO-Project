package com.mycompany.app.events;

import com.mycompany.app.participants.Participant;
import com.mycompany.app.events.Event;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fair extends Event {
    private int numOfStands;

    public Fair(String title, LocalDate date, String location, int capacity, String description, String modality, int numOfStands) {
        super(title, date, location, capacity, description, modality);
        this.numOfStands = numOfStands;
    }

    @Override
    public String getType() {
        return "Fair";
    }

    @Override
    public boolean canParticipate(Participant p) {
        return true;
    }

    public int getNumOfStands() {
        return numOfStands;
    }

    @Override
    public String toString() {
        return super.toString() + "\\nStands: " + numOfStands;
    }
}