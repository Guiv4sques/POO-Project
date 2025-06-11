package com.mycompany.app.participants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Participant {
    protected String name;
    protected String email;

    public Participant(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public abstract String getType();

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("%s: %s <%s>", getType(), name, email);
    }
}