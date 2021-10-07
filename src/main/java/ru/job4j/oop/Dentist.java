package ru.job4j.oop;

public class Dentist extends Doctor {
    private short tooth;

    public Dentist(String name, String surname, String education, String birthday,
                   String hospital, int cabinet, short tooth) {
        super(name, surname, education, birthday, hospital, cabinet);
        this.tooth = tooth;
    }

    public void remove() {
    }
}
