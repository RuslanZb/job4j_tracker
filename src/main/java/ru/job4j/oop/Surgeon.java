package ru.job4j.oop;

public class Surgeon extends Doctor {
    private String operation;

    public Surgeon(String name, String surname, String education, String birthday,
                   String hospital, int cabinet, String operation) {
        super(name, surname, education, birthday, hospital, cabinet);
        this.operation = operation;
    }

    public void appendicitis() {
    }
}
