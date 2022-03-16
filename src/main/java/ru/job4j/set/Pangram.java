package ru.job4j.set;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Pangram {
    public static boolean checkString(String s) {
        Set<Character> symbol = new HashSet<>();
        s = s.toLowerCase(Locale.ROOT).replace(" ", "");
        for (int i = 0; i < s.length(); i++) {
            symbol.add(s.charAt(i));
        }
        return symbol.size() == 26;
    }
}