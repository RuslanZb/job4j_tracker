package ru.job4j.inheritance;

import ru.job4j.tracker.Item;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item date = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        LocalDateTime currentDate = date.getCreated();
        String currentDateFormat = currentDate.format(formatter);
        System.out.println(currentDateFormat);
    }
}
