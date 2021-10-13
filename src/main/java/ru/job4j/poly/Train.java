package ru.job4j.poly;

public class Train implements Vehicle {
    private String name;
    public Train(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(name + " передвигается по рельсам");
    }

    @Override
    public void fuel() {
        System.out.println("Топливо дизель");
    }
}
