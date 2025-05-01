package com.example.Lv2;
import java.util.*;

public class Calculator {
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }
    public ArrayList<Integer> getList() {
        return list;
    }


    public int calculate(int operand1, int operand2, char operator) {
        int res = 0;
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
                if (operand2 == 0) System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
                else res = operand1 / operand2;
                break;
            default:
                System.out.println("연산자 입력이 잘못되었습니다.");
        }
        list.add(res);
        return res;
    }
}
