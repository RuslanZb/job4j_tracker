package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        new Fact().calc(-1);

    }

    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N should be greater than or equal to zero.");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
