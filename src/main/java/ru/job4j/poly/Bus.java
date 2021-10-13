package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Транспорт поехал");
    }

    @Override
    public void passenger(int number) {
        System.out.println("В транспорте " + number + " пассажиров.");
    }

    @Override
    public double fill(double fuel) {
        return fuel * 50;
    }
}
