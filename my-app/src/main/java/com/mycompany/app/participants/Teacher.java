package com.mycompany.app.participants;

import com.mycompany.app.participants.Participant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Participant {
    private String siape;
    private String areaActivity;

    public Teacher(String name, String email, String siape, String areaActivity) {
        super(name, email);
        this.siape = siape;
        this.areaActivity = areaActivity;
    }

    @Override
    public String getType() {
        return "Teacher";
    }

    public String getSiape() {
        return siape;
    }

    public String getAreaActivity() {
        return areaActivity;
    }

    @Override
    public String toString() {
        return super.toString() + " | SIAPE: " + siape + " | Area: " + areaActivity;
    }
}