package com.example.calctest.service;

import com.example.calctest.impl.CalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static com.example.calctest.CalcConstants.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CalculatorServiceTestParam {
    private final CalculatorServiceImpl calculatorServiceImpl = new CalculatorServiceImpl();


    public static Stream<Arguments> testPlusWithParams() {
        return Stream.of(
                Arguments.of(null, null, INCORRECT_DATA),
                Arguments.of(THREE, null, INCORRECT_DATA),
                Arguments.of(null, THREE, INCORRECT_DATA),
                Arguments.of(ONE, THREE, ANSWER_PLUS)
        );
    }
    @ParameterizedTest
    @MethodSource("testPlusWithParams")
    public void parametrizedTestSum(Integer num1, Integer num2, String expected) {
        String actual = calculatorServiceImpl.plus(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    public static Stream<Arguments> testMinusWithParams() {
        return Stream.of(
                Arguments.of(THREE, ONE, ANSWER_MINUS),
                Arguments.of(null, ONE, INCORRECT_DATA),
                Arguments.of(THREE, null, INCORRECT_DATA),
                Arguments.of(null, null, INCORRECT_DATA)
        );
    }
    @ParameterizedTest
    @MethodSource("testMinusWithParams")
    public void parametrizedTest(Integer num1, Integer num2, String expected) {
        String actual = calculatorServiceImpl.minus(num1, num2);
        Assertions.assertEquals(expected, actual);
    }



    public static Stream<Arguments> testMultiplyWithParams() {
        return Stream.of(
                Arguments.of(null, null, INCORRECT_DATA),
                Arguments.of(TWO, null, INCORRECT_DATA),
                Arguments.of(null, TWO, INCORRECT_DATA),
                Arguments.of(TWO, TWO, ANSWER_MULTIPLY)
        );
    }
    @ParameterizedTest
    @MethodSource("testMultiplyWithParams")
    public void parametrizedTestMultiply(Integer num1, Integer num2, String expected) {
        String actual = calculatorServiceImpl.multiply(num1, num2);
        Assertions.assertEquals(expected, actual);
    }


    public static Stream<Arguments> testDivideWithParams() {
        return Stream.of(
                Arguments.of(null, null, INCORRECT_DATA),
                Arguments.of(FOUR, null, INCORRECT_DATA),
                Arguments.of(null, TWO, INCORRECT_DATA),
                Arguments.of(FOUR, TWO, ANSWER_DIVIDE)
        );
    }
    @ParameterizedTest
    @MethodSource("testDivideWithParams")
    public void parametrizedTestDivide(Integer num1, Integer num2, String expected) {
        String actual = calculatorServiceImpl.divide(num1, num2);
        Assertions.assertEquals(expected, actual);
    }



    public static Stream<Arguments> testDivideByZeroWithParams() {
        return Stream.of(
                Arguments.of(TWO, ZERO, IllegalArgumentException.class)
        );
    }
    @ParameterizedTest
    @MethodSource("testDivideByZeroWithParams")
    public void parametrizedTestDivideByZero(Integer num1, Integer num2, Class<Throwable> typeException) {
        Assertions.assertThrows(typeException, () -> calculatorServiceImpl.divide(num1, num2));
    }
}