package ru.job4j.oop;

public class Max {
    public int max(int x1, int x2) {
        return x1 > x2 ? x1 : x2;
    }

    public int max(int x1, int x2, int x3) {
        return max(x1, max(x2, x3));
    }

    public int max(int x1, int x2, int x3, int x4) {
        return max(x1, max(x2, x3, x4));
    }
}
