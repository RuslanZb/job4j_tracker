package ru.job4j.oop;

public class Doctor extends Profession {
    private String hospital;
    private int cabinet;

    public Doctor(String name, String surname, String education, String birthday,
                  String hospital, int cabinet) {
        super(name, surname, education, birthday);
        this.cabinet = cabinet;
        this.hospital = hospital;
    }

    public String getHospital() {
        return this.hospital;
    }

    public int getCabinet() {
        return this.cabinet;
    }
}
