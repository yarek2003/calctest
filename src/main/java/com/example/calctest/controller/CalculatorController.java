package com.example.calctest.controller;

import com.example.calctest.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String welcome() {
        return calculatorService.welcome();
    }

    @GetMapping(path = "/plus")
    public String plus(Integer num1, Integer num2) {
        return calculatorService.plus(num1, num2);
    }

    @GetMapping(path = "/minus")
    public String minus(Integer num1, Integer num2) {
        return calculatorService.minus(num1, num2);
    }

    @GetMapping(path = "/multiply")
    public String multiply(Integer num1, Integer num2) {
        return calculatorService.multiply(num1, num2);
    }


    @GetMapping(path = "/divide")
    public String divide(Integer num1, Integer num2) {
        return calculatorService.divide(num1, num2);
    }
}
