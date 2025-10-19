package calculator.model;

import java.util.regex.Pattern;

public class Calculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        String numbers = input;

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            if (delimiterIndex == -1) {
                delimiterIndex = input.indexOf("\\n");
                if (delimiterIndex == -1) {
                    throw new IllegalArgumentException("잘못된 커스텀 구분자 형식");
                }
                delimiter = Pattern.quote(input.substring(2, delimiterIndex));
                numbers = input.substring(delimiterIndex + 2);
            } else {
                delimiter = Pattern.quote(input.substring(2, delimiterIndex));
                numbers = input.substring(delimiterIndex + 1);
            }
        }

        String[] tokens = numbers.split(delimiter);
        int sum = 0;

        for (String token : tokens) {
            if (token.isEmpty()) {
                throw new IllegalArgumentException("잘못된 입력: 연속된 구분자");
            }

            int num;
            try {
                num = Integer.parseInt(token);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값 포함");
            }

            if (num < 0) {
                throw new IllegalArgumentException("음수 입력 불가");
            }

            sum += num;
        }

        return sum;
    }
}
