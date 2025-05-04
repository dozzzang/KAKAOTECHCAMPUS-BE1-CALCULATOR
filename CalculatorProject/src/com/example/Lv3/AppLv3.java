package com.example.Lv3;

import com.example.Lv3.ArithmeticCalculatorLv3;

import java.util.ArrayList;
import java.util.Scanner;

public class AppLv3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Lv1 에서 구현한 App클래스의 main메서드에 Calculator 클래스가 활용될 수 있도록 수정
        ArithmeticCalculatorLv3 calculator = new ArithmeticCalculatorLv3();
        while (true) {
            System.out.print("계산 타입을 선택하세요(0: Integer, 1: Double): ");
            int toggle = sc.nextInt();

            //operand가 Integer일 때
            if (toggle == 0) {
                // Lv2 calculator와 같이 0으로 나눠도 계속 계산기를 사용할 수 있도록 수정
                try {
                    System.out.print("첫 번째 숫자를 입력하세요:");
                    int num1 = sc.nextInt();
                    System.out.print("두 번째 숫자를 입력하세요:");
                    int num2 = sc.nextInt();
                    System.out.print("사칙연산 기호를 입력하세요: ");
                    char charOperator = sc.next().charAt(0);

                    //OperatorType operatorType = new OperatorType(charOperator);
                    OperatorType operatorType = OperatorType.translateOperator(charOperator);
                    Integer res = (Integer) calculator.calculate(num1, num2, operatorType);

                    //getter 활용
                    if (res == calculator.getList().get(calculator.getList().size() - 1)) {
                        System.out.println("결과: " + res);
                        calculator.printBiggerResult(res, toggle);
                    }
                } catch (ArithmeticException e) {
                    System.out.println("예외 :  " + e.getMessage());
                    continue;
                }
                while (true) {
                    System.out.print("더 계산하시겠습니까? (y를 입력하세요)\n (exit 입력 시 종료)\n (C 입력 시 모든 연산 결과 삭제)" +
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

            //operand가 Double일 때
            if(toggle == 1) {
                try {
                    System.out.print("첫 번째 숫자를 입력하세요:");
                    double num1 = sc.nextDouble();
                    System.out.print("두 번째 숫자를 입력하세요:");
                    double num2 = sc.nextDouble();
                    System.out.print("사칙연산 기호를 입력하세요: ");
                    char charOperator = sc.next().charAt(0);

                    //OperatorType operatorType = new OperatorType(charOperator);
                    OperatorType operatorType = OperatorType.translateOperator(charOperator);
                    Double res = (Double)calculator.calculate(num1, num2, operatorType);

                    //getter 활용
                    if (res == calculator.getList().get(calculator.getList().size() - 1)) {
                        System.out.println("결과: " + res);
                        calculator.printBiggerResult(res,toggle);
                    }
                } catch (ArithmeticException e) {
                    System.out.println("예외 :  " + e.getMessage());
                    continue;
                }
                System.out.print("더 계산하시겠습니까?\n (exit 입력 시 종료)\n (C 입력 시 모든 연산 결과 삭제)" +
                        "\n (show 입력 시 이전 결과 출력)\n (R입력 시 첫번째 연산 결과 삭제)");
                String input = sc.next();
                if (input.equals("exit")) break;
                    //setter 활용
                else if (input.equals("C")) calculator.setList(new ArrayList<>());
                    // getter 활용
                else if (input.equals("show")) {
                    for (int i = 0; i < calculator.getList().size(); i++)
                        System.out.println(calculator.getList().get(i));
                }
                //삭제 메서드가 활용될 수 있도록 수정
                else if (input.equals("R")) calculator.removeResult();
            }
        }


    }
}
