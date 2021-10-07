package ru.job4j.oop;

public class Engineer extends Profession {
    private String field;

    public Engineer(String name, String surname, String education, String birthday,
                    String field) {
        super(name, surname, education, birthday);
        this.field = field;
    }

    public String getField() {
        return this.field;
    }
}
