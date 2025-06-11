package com.mycompany.app.events;

import com.mycompany.app.events.Event;
import com.mycompany.app.participants.Participant;
import com.mycompany.app.participants.Student;
import com.mycompany.app.participants.Outsider;
import com.mycompany.app.participants.Teacher;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course extends Event {
    private int workLoad;

    public Course(String title, LocalDate date, String location, int capacity, String description, String modality, int workLoad) {
        super(title, date, location, capacity, description, modality);
        this.workLoad = workLoad;
    }

    @Override
    public String getType() {
        return "Course";
    }

    @Override
    public boolean canParticipate(Participant p) {
        return p instanceof Student;
    }

    public int getWorkLoad() {
        return workLoad;
    }

    @Override
    public String toString() {
        return super.toString() + "\\nWorkload: " + workLoad + " hours";
    }
}