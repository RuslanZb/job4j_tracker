package ru.job4j.oop;

public class Electric extends Engineer {
    private double amperage;

    public Electric(String name, String surname, String education, String birthday,
                    String field, double amperage) {
        super(name, surname, education, birthday, field);
        this.amperage = amperage;
    }

    public void measuring() {
    }
}
