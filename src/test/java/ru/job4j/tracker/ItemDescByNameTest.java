package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void whenDescSort() {
        List<Item> items = Arrays.asList(
                new Item("Tom"),
                new Item("Albus"),
                new Item("Frodo"),
                new Item("Bim")
        );
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("Tom"),
                new Item("Frodo"),
                new Item("Bim"),
                new Item("Albus")
        );
        assertEquals(expected, items);
    }
}