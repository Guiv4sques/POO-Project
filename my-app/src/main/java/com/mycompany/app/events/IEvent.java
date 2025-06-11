package com.mycompany.app.events;

import com.mycompany.app.participants.Participant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface IEvent {
    public List<Participant> getParticipants();
    public abstract String getType();
    public String getTitle();
    public LocalDate getDate ();
    public String getModality ();
    public String getDescription ();
    public abstract boolean canParticipate(Participant p);
}