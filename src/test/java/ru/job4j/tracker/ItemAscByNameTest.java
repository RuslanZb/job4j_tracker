package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemAscByNameTest {
    @Test
    public void whenAscSort() {
        List<Item> items = Arrays.asList(
                new Item("Tom"),
                new Item("Albus"),
                new Item("Frodo"),
                new Item("Bim")
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("Albus"),
                new Item("Bim"),
                new Item("Frodo"),
                new Item("Tom")
        );
        assertEquals(expected, items);
    }
}