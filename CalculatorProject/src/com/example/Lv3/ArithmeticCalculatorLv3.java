package com.example.Lv3;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.example.Lv3.OperatorType;

public class ArithmeticCalculatorLv3<T extends Number> {
        private ArrayList<T> list = new ArrayList<T>();
        //App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정 (캡슐화)
        public void setList(ArrayList<T> list) {
            this.list = list;
        }
        public ArrayList<T> getList() {
            return list;
        }

        //사칙연산을 수행하고 결과값을 반환하는 메소드
        public T calculate(T operand1, T operand2, OperatorType operator) {
//            int res = operator.calculate(operand1,operand2);
            if(operator == OperatorType.DIVIDE && (operand2.intValue() == 0 || operand2.doubleValue() == 0.0))
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
            T res = operator.calculate(operand1,operand2);
            saveResult(res);
            return res;
        }
        //연산 결과를 Calculator 클래스의 연산 결과를 저장하는 컬렉션 필드에 저장
        private void saveResult(T result) {
            list.add(result);
        }
        //Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현
        public void removeResult() {
            if(list.isEmpty())
                System.out.println("연산 결과가 없으므로 삭제가 불가합니다.");
            else list.remove(0);
        }

        //저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 출력
        public void printBiggerResult(T num,int toggle) {
            if(toggle == 1) {
            ArrayList<T> returningList= list.stream()
                    .filter(result -> result.doubleValue() > num.doubleValue())
                    .collect(Collectors.toCollection(ArrayList::new));
                if(returningList.isEmpty())
                    System.out.println("결과 값보다 큰 값이 이전 결과 중에 없습니다.");
                else {
                    System.out.print("이전 결과들 중 현재 결과 값보다 큰 값들 : ");
                    for(T e : returningList)
                        System.out.println(e);
                }
            }

            if(toggle == 0) {
                ArrayList<T> returningList= list.stream()
                        .filter(result -> result.intValue() > num.intValue())
                        .collect(Collectors.toCollection(ArrayList::new));
                if(returningList.isEmpty())
                    System.out.println("결과 값보다 큰 값이 이전 결과 중에 없습니다.");
                else {
                    System.out.print("이전 결과들 중 현재 결과 값보다 큰 값들 : ");
                    for(T e : returningList)
                        System.out.println(e);
                }
            }
        }
        //추가 메서드
    }
