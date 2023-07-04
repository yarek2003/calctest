package com.example.calctest.impl;

import com.example.calctest.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    public String welcome() {

        return "Добро пожаловать в калькулятор";
    }

    public String plus(Integer num1, Integer num2) {
        String result = check(num1, num2);
        if (result != null) {
            return result;
        }
        return  num1 + " + " + num2 + " = " + (num1 + num2);

    }

    public String minus(Integer num1, Integer num2) {
        String result = check(num1, num2);
        if (result != null) {
            return result;
        }
        return  num1 + " - " + num2 + " = " + (num1 - num2);
    }

    public String multiply(Integer num1, Integer num2) {
        String result = check(num1, num2);
        if (result != null) {
            return result;
        }
        return  num1 + " * " + num2 + " = " + num1 * num2;
    }

    public String divide(Integer num1, Integer num2) {
        String result = check(num1, num2);
        if (result != null) {
            return result;
        }
        if (num2 == 0) {
            throw new IllegalArgumentException();
        }
        return num1 + " / " + num2 + " = " + num1/num2;
    }

    public static String check(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            return "Один из аргументов не введен";
        }
        return null;
    }
}
