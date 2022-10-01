package 코테연습.키패드누르기;
/*
* 1 2 3
* 4 5 6
* 7 8 9
* * 0 #
* 왼쪽 손가락만 사용 1 4 7
* 오른쪽 손가락만 사용 3 6 9
* 가운데 열의 숫자는 현재 키패드 위치에서 더 가까운 엄지손가락 사용
* 거리가 같으면, 오른손 잡이는 오른쪽 사용, 왼손 잡이는 왼손 사용
* numbers : 순서대로 누를 번호가 담긴 배열
* hand : 왼손잡이인지 오른손 잡이인지
* 각 번호를 누른 엄지손가락이 왼손인지 오른손인지
* 나타내는 연속된 문자열 형태로 출력하기*/

import java.io.*;
import java.util.*;

class Solution { // numbers 버튼 누르는 순서, hand 왼손or오른손
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int leftPoint = 10;
        int rightPoint = 12;

        for(int i=0; i<numbers.length; i++){
            int button = numbers[i];
            if(button==1 || button==4 || button==7){ // 왼손
                sb.append("L");
                leftPoint = button;
            } else if(button==3 || button==6 || button==9){ // 오른손
                sb.append("R");
                rightPoint = button;
            } else{ // 가운데 1.거리비교 2. 다르면 가까운거, 같으면 hand손잡이
                if(button==0){
                    button=11;
                }
                int leftLength = Math.abs(button-leftPoint)/3+Math.abs(button-leftPoint)%3;
                int rightLength = Math.abs(button-rightPoint)/3+Math.abs(button-rightPoint)%3;

                if(leftLength<rightLength){
                    leftPoint = button;
                    sb.append("L");
                } else if(leftLength>rightLength){
                    rightPoint = button;
                    sb.append("R");
                } else { // equal
                    if(hand.equals("left")){
                        leftPoint = button;
                        sb.append("L");
                    } else { // right
                        rightPoint = button;
                        sb.append("R");
                    }
                }
            }
        }
        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        Solution T= new Solution();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(T.solution(numbers, hand));
    }
}
