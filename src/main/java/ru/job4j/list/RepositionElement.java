package ru.job4j.list;

import java.util.List;

public class RepositionElement {
    public static List<String> changePosition(List<String> list, int index) {
        String el = list.remove(list.size() - 1);
        if (index >= 0 && index < list.size()) {
            list.set(index, el);
        }
        return list;
    }
}