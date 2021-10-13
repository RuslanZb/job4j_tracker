package ru.job4j.poly;

public class PolyVehicle {
    public static void main(String[] args) {
        Vehicle sapsan = new Train("Сапсан");
        Vehicle lastochka = new Train("Ласточка");
        Vehicle airbus = new Airplane("Айробус");
        Vehicle boeing = new Airplane("Боинг");
        Vehicle paz = new Autobus("ПАЗ");
        Vehicle ikarus = new Autobus("Икарус");

        Vehicle[] vehicles = new Vehicle[] {sapsan, lastochka, airbus, boeing, paz, ikarus};
        for (Vehicle veh : vehicles) {
            veh.move();
            veh.fuel();
        }
    }
}
