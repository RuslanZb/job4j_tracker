package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FunctionResTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionRes function = new FunctionRes();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D, 17D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        FunctionRes function = new FunctionRes();
        List<Double> result = function.diapason(-2, 2, x -> x * x);
        List<Double> expected = Arrays.asList(4D, 1D, 0D, 1D, 4D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        FunctionRes function = new FunctionRes();
        List<Double> result = function.diapason(-3, 3, x -> Math.pow(1, x));
        List<Double> expected = Arrays.asList(1D, 1D, 1D, 1D, 1D, 1D, 1D);
        assertThat(result, is(expected));
    }
}