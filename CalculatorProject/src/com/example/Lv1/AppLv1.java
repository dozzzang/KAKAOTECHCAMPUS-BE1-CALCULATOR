package com.example.Lv1;
import java.util.*;

public class AppLv1 {
    public static void main(String[] args) {
        int res = 0;
        Scanner sc = new Scanner(System.in);

        while(true) {
            //양의 정수를 입력받기
            System.out.print("첫 번째 정수를 입력하세요 : ");
            int operand1 = sc.nextInt();
            System.out.print("두 번째 정수를 입력하세요 : ");
            int operand2 = sc.nextInt();
            //사칙연산 기호를 입력받기
            System.out.print("사칙연산 기호를 입력하세요 : ");
            char operator = sc.next().charAt(0);
            //연산 진행 후 결과 출력
            switch (operator) {
                case '+':
                    res = operand1 + operand2;
                    break;
                case '-':
                    res = operand1 - operand2;
                    break;
                case '*':
                    res = operand1 * operand2;
                    break;
                case '/':
                    //연산 오류 처리
                    if (operand2 == 0) System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
                    else res = operand1 / operand2;
                    break;
                default:
                    System.out.println("연산자 입력이 잘못되었습니다.");
            }
            System.out.println("결과: " + res);
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료)");
            //exit가 입력될 시 반복문 종료
            if(sc.next().equals("exit")) break;
        }
    }
}