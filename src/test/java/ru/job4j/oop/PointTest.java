package ru.job4j.oop;

import org.junit.Test;
import org.junit.Assert;

public class PointTest {
    @Test
    public void whenThen10() {
        int x1 = 1;
        int x2 = 10;
        Max max = new Max();
        int result = max.max(x1, x2);
        int expected = 10;
        Assert.assertEquals(result, expected);
    }
}