package calculator.controller;

import calculator.model.Calculator;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final Calculator calculator;
    private final CalculatorView view;

    public CalculatorController(Calculator calculator, CalculatorView view) {
        this.calculator = calculator;
        this.view = view;
    }

    public void run() {
        String input = view.getInput();
        int result = calculator.add(input);
        view.displayResult(result);
        view.close();
    }
}
