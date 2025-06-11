package com.mycompany.app.participants;

import com.mycompany.app.participants.Participant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends Participant {
    private String registration;
    private String course;

    public Student(String name, String email, String registration, String course) {
        super(name, email);
        this.registration = registration;
        this.course = course;
    }

    @Override
    public String getType() {
        return "Student";
    }

    public String getRegistration() {
        return registration;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return super.toString() + " | Registration: " + registration + " | Course: " + course;
    }
}