package com.example.calctest.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.example.calctest.CalcConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {
    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
    @Test
    void welcome() {
    }

    @Test
    void plusIfParameterIsEmpty() {
        String result = calculatorService.plus(null, null);
        Assertions.assertEquals(INCORRECT_DATA, result);
    }
    @Test
    void plusIfParameterIsNotEmpty() {
        String result = calculatorService.plus(ONE, THREE);
        Assertions.assertEquals(ANSWER_PLUS, result);
    }

    @Test
    void minusIfParameterIsEmpty() {
        String result = calculatorService.minus(null, null);
        Assertions.assertEquals(INCORRECT_DATA, result);
    }
    @Test
    void minusIfParameterIsNotEmpty() {
        String result = calculatorService.minus(THREE, ONE);
        Assertions.assertEquals(ANSWER_MINUS, result);
    }

    @Test
    void multiplyIfParameterIsNotEmpty() {
        String result = calculatorService.multiply(TWO, TWO);
        Assertions.assertEquals(ANSWER_MULTIPLY, result);
    }

    @Test
    void multiplyIfParameterIsEmpty() {
        String result = calculatorService.multiply(TWO, null);
        Assertions.assertEquals(INCORRECT_DATA, result);
    }

    @Test
    void divideIfArgumentIsZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(TWO, ZERO));
    }

    @Test
    void divideIfArgumentIsNotEmpty() {
        String result = calculatorService.divide(FOUR, TWO);
        Assertions.assertEquals(ANSWER_DIVIDE, result);
    }

    @Test
    void divideIfArgumentIsEmpty() {
        String result = calculatorService.divide(null, TWO);
        Assertions.assertEquals(INCORRECT_DATA, result);
    }
}