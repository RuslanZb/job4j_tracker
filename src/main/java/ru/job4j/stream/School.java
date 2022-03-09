package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students,
                                 Predicate<Student> predic) {
        return students.stream()
                .filter(predic)
                .collect(Collectors.toList());
    }
}
