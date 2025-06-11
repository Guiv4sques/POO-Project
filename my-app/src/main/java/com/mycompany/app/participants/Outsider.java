package com.mycompany.app.participants;

import com.mycompany.app.participants.Participant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Outsider extends Participant {
    private String institution;
    private String ocupation;

    public Outsider(String name, String email, String institution, String ocupation) {
        super(name, email);
        this.institution = institution;
        this.ocupation = ocupation;
    }

    @Override
    public String getType() {
        return "Outsider";
    }

    public String getInstitution() {
        return institution;
    }

    public String getOcupation() {
        return ocupation;
    }

    @Override
    public String toString() {
        return super.toString() + " | Institution: " + institution + " | Ocupation: " + ocupation;
    }
}