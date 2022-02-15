package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class SubList {
    public static List<String> getElementsBetweenIndexes(List<String> list, String el) {
        List<String> rsl = new ArrayList<>();
        int first = list.indexOf(el);
        int last = list.lastIndexOf(el);
        if (first != last && first != -1) {
            rsl = list.subList(first, last);
        }
        return rsl;
    }
}