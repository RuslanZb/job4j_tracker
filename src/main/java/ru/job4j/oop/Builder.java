package ru.job4j.oop;

public class Builder extends Engineer {
    private String structure;

    public Builder(String name, String surname, String education, String birthday,
                   String field, String structure) {
        super(name, surname, education, birthday, field);
        this.structure = structure;
    }

    public void building() {
    }
}
