package ru.job4j.list;

import java.util.List;

public class AddAllElementsList {
    public static int containsElement(List<String> left, List<String> right, String str) {
        for (String elLeft : left) {
            for (String elRight : right) {
                if (str.equals(elLeft) && str.equals(elRight)) {
                    left.remove(str);
                    break;
                }
            }
        }
        left.addAll(right);
        return left.indexOf(str);
    }
}