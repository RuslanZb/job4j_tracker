package ru.job4j.stream;

import java.util.*;
import java.util.stream.*;

public class FlatIt {

    public static List<Integer> flatten(Iterator<Iterator<Integer>> it) {
        return iteratorToStream(it)
                .flatMap(FlatIt::iteratorToStream)
                .collect(Collectors.toList());
    }

    private static <T> Stream<T> iteratorToStream(Iterator<T> it) {
        return StreamSupport.stream(Spliterators
                .spliteratorUnknownSize(it, Spliterator.ORDERED), false);
    }

}
