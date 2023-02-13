package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double sum = 0;
        for (Pupil pupil : pupils) {
            sum += scoreByPupil(pupil);
            count +=pupil.subjects().size();
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            rsl.add(new Label(pupil.name(), scoreByPupil(pupil) / pupil.subjects().size()));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subMap = new LinkedHashMap<>();
        List<Label> rsl = new ArrayList<>();
        double size = pupils.size();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subMap.put(subject.name(),
                        subMap.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String name : subMap.keySet()) {
            rsl.add(new Label(name, subMap.get(name) / size));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            rsl.add(new Label(pupil.name(), scoreByPupil(pupil)));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                temp.put(subject.name(),
                        temp.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String name : temp.keySet()) {
            rsl.add(new Label(name, temp.get(name)));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }

    private static double scoreByPupil (Pupil pupil) {
        double sum = 0.0;
        for (Subject subject : pupil.subjects()) {
            sum += subject.score();
        }
        return sum;
    }
}
