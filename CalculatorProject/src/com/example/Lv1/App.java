package com.example.Lv1;
import java.util.*;
import com.example.Lv2.Calculator;

public class App {
    public static void main(String[] args) {
        int res = 0;
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();
        while(true) {
            System.out.print("첫 번째 숫자를 입력하세요:");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요:");
            int num2 = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);
            res = calculator.calculate(num1,num2,operator);
            if(res == calculator.getList().get(calculator.getList().size() - 1))
                System.out.println("결과: " + res);
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료)");
            if(sc.next().equals("exit")) break;
        }
            }
                }