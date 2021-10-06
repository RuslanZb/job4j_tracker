package ru.job4j.oop;

import org.junit.Test;
import org.junit.Assert;

public class PointTest {
    @Test
    public void when10101314Then5() {
        Point a = new Point(10, 10);
        Point b = new Point(13, 14);
        double dist = a.distance(b);
        double expected = 5;
        Assert.assertEquals(dist, expected, 2);
    }

    @Test
    public void whenMinus123115Then3() {
        Point a = new Point(-1, 2, 3);
        Point b = new Point(1, 1, 5);
        double dist = a.distance(b);
        double expected = 3;
        Assert.assertEquals(dist, expected, 2);
    }
}