package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = sc.nextLine();
        sc.close();

        int result = add(input);
        System.out.println("결과 : " + result);
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자
        String numbers = input;

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n"); // 실제 개행
            if (delimiterIndex == -1) {
                // "\n"이 아닌 문자열 상 "\\n" 처리
                delimiterIndex = input.indexOf("\\n");
                if (delimiterIndex == -1) {
                    throw new IllegalArgumentException("잘못된 커스텀 구분자 형식");
                }
                delimiter = Pattern.quote(input.substring(2, delimiterIndex));
                numbers = input.substring(delimiterIndex + 2); // "\\n" 길이 2
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
