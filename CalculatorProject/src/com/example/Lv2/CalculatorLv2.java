package com.example.Lv2;
import java.util.*;

public class CalculatorLv2 {
    private ArrayList<Integer> list = new ArrayList<Integer>();
    //App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정 (캡슐화)
    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }
    public ArrayList<Integer> getList() {
        return list;
    }

    //사칙연산을 수행하고 결과값을 반환하는 메소드
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
                if (operand2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
                    return res; }
                else res = operand1 / operand2;
                break;
            default:
                System.out.println("연산자 입력이 잘못되었습니다.");
        }
        saveResult(res);
        return res;
    }
    //연산 결과를 Calculator 클래스의 연산 결과를 저장하는 컬렉션 필드에 저장
    private void saveResult(int result) {
        list.add(result);
    }
    //Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현
    public void removeResult() {
        if(list.isEmpty())
            System.out.println("연산 결과가 없으므로 삭제가 불가합니다.");
        else list.remove(0);
    }
}
