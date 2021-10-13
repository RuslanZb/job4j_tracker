package ru.job4j.poly;

public class Autobus implements Vehicle {
    private String name;
    public Autobus(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(name + " передвигается по асфальту");
    }

    @Override
    public void fuel() {
        System.out.println("Топливо бензин");
    }
}
