package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.*;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenComparatorAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Task A", 1),
                new Job("Task B", 3),
                new Job("Task D", 0),
                new Job("Task C", 2)
        );
        Collections.sort(jobs, new JobAscByName());
        List<Job> expected = Arrays.asList(
                new Job("Task A", 1),
                new Job("Task B", 3),
                new Job("Task C", 2),
                new Job("Task D", 0)
        );
        assertEquals(expected, jobs);
    }

    @Test
    public void whenComparatorDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Task A", 1),
                new Job("Task B", 3),
                new Job("Task D", 0),
                new Job("Task C", 2)
        );
        Collections.sort(jobs, new JobDescByName());
        List<Job> expected = Arrays.asList(
                new Job("Task D", 0),
                new Job("Task C", 2),
                new Job("Task B", 3),
                new Job("Task A", 1)
        );
        assertEquals(expected, jobs);
    }

    @Test
    public void whenComparatorAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Task A", 1),
                new Job("Task B", 3),
                new Job("Task D", 0),
                new Job("Task C", 2)
        );
        Collections.sort(jobs, new JobAscByPriority());
        List<Job> expected = Arrays.asList(
                new Job("Task D", 0),
                new Job("Task A", 1),
                new Job("Task C", 2),
                new Job("Task B", 3)
        );
        assertEquals(expected, jobs);
    }

    @Test
    public void whenComparatorDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Task A", 1),
                new Job("Task B", 3),
                new Job("Task D", 0),
                new Job("Task C", 2)
        );
        Collections.sort(jobs, new JobDescByPriority());
        List<Job> expected = Arrays.asList(
                new Job("Task B", 3),
                new Job("Task C", 2),
                new Job("Task A", 1),
                new Job("Task D", 0)
        );
        assertEquals(expected, jobs);
    }

    @Test
    public void whenComparatorAscByNameAndAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Task A", 1),
                new Job("Task B", 3),
                new Job("Task D", 0),
                new Job("Task A", 2)
        );
        Collections.sort(jobs, new JobAscByName().thenComparing(new JobAscByPriority()));
        List<Job> expected = Arrays.asList(
                new Job("Task A", 1),
                new Job("Task A", 2),
                new Job("Task B", 3),
                new Job("Task D", 0)
        );
        assertEquals(expected, jobs);
    }

    @Test
    public void whenComparatorDescByNameAndAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Task A", 1),
                new Job("Task B", 3),
                new Job("Task D", 0),
                new Job("Task A", 2)
        );
        Collections.sort(jobs, new JobDescByName().thenComparing(new JobAscByPriority()));
        List<Job> expected = Arrays.asList(
                new Job("Task D", 0),
                new Job("Task B", 3),
                new Job("Task A", 1),
                new Job("Task A", 2)
        );
        assertEquals(expected, jobs);
    }

    @Test
    public void whenComparatorDescByPriorityAndAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Task A", 1),
                new Job("Task B", 1),
                new Job("Task D", 0),
                new Job("Task A", 2)
        );
        Collections.sort(jobs, new JobDescByPriority().thenComparing(new JobAscByName()));
        List<Job> expected = Arrays.asList(
                new Job("Task A", 2),
                new Job("Task B", 1),
                new Job("Task A", 1),
                new Job("Task D", 0)
        );
        assertEquals(expected, jobs);
    }
}