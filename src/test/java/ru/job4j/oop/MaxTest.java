package ru.job4j.oop;

import org.junit.Test;
import org.junit.Assert;

public class MaxTest {

    @Test
    public void when2Then10() {
        int x1 = 1;
        int x2 = 10;
        Max max = new Max();
        int result = max.max(x1, x2);
        int expected = 10;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void when3Then20() {
        int x1 = 0;
        int x2 = -10;
        int x3 = 20;
        Max max = new Max();
        int result = max.max(x1, x2, x3);
        int expected = 20;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void when4Then100() {
        int x1 = 1;
        int x2 = -10;
        int x3 = 100;
        int x4 = 10;
        Max max = new Max();
        int result = max.max(x1, x2, x3, x4);
        int expected = 100;
        Assert.assertEquals(result, expected);
    }
}