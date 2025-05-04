package com.example.Lv2;

import java.util.ArrayList;
import java.util.Scanner;

public class AppLv2 {
    public static void main(String[] args) {
        int res = 0;
        Scanner sc = new Scanner(System.in);
        //Lv1 에서 구현한 App클래스의 main메서드에 Calculator 클래스가 활용될 수 있도록 수정
        CalculatorLv2 calculator = new CalculatorLv2();

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요:");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요:");
            int num2 = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            res = calculator.calculate(num1, num2, operator);

            //getter 활용
            if (res == calculator.getList().get(calculator.getList().size() - 1))
                System.out.println("결과: " + res);

            while (true) {
                System.out.print("더 계산하시겠습니까?(y를 입력하세요.)\n (exit 입력 시 종료)\n (C 입력 시 모든 연산 결과 삭제)" +
                        "\n (show 입력 시 이전 결과 출력)\n (R입력 시 첫번째 연산 결과 삭제)\n");
                String input = sc.next();
                if (input.equals("exit")) break;
                    //setter 활용
                else if (input.equals("C")) calculator.setList(new ArrayList<>());
                    // getter 활용
                else if (input.equals("show")) {
                    System.out.print("이전 결과들 : ");
                    for (int i = 0; i < calculator.getList().size(); i++)
                        System.out.print(calculator.getList().get(i) + " ");
                    System.out.print("\n");
                }
                //삭제 메서드가 활용될 수 있도록 수정
                else if (input.equals("R")) calculator.removeResult();
                    // 더 계산하는 경우
                else if (input.equals("y")) break;
                    // 이외의 경우
                else throw new ArithmeticException();
            }
        }
    }
}