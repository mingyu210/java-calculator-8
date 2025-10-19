package calculator.view;

import java.util.Scanner;

public class CalculatorView {
    private final Scanner scanner = new Scanner(System.in);

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return scanner.nextLine();
    }

    public void displayResult(int result) {
        System.out.println("결과 : " + result);
    }

    public void displayError(String message) {
        System.out.println(message);
    }

    public void close() {
        scanner.close();
    }
}
