package ru.job4j.oop;

public class BallStory {

    public static void main(String[] args) {
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        hare.tryEat();
        wolf.tryEat();
        fox.tryEat();
    }
}
