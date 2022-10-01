package swea.d1.문제풀이;
// 2072 홀수만 더하기
// 2071 평균값 구하기(Math.round 반올림, ceil 올림, floor 내림)
// 2070 큰놈, 작은놈, 같은놈
// 2058 자릿수 더하기 str.toCharArray()
// 2050 알파벳을 숫자로 변환
// 2047 신문 헤드라인 str.toUpperCase
// 2046 스탬프 찍기 StringBuilder
// 2043 서랍의 비밀번호
// 2029 몫과 나머지 출력하기
// 2027 대각선 출력하기
// 2025 N줄덧셈
// 1938 아주 간단한 계산기
// 1936 1대1 가위바위보
// 2019 더블더블
// 1545 거꾸로 출력해 보아요

import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=1; i<=T; i++){
            StringBuilder sb = new StringBuilder();
            boolean flag = true;
            String str = sc.next();
            char[] arr = str.toCharArray();

            for(int j=0; j<4; j++){
                sb.append(arr[j]);
            }
            //int year = Integer.parseInt(sb.toString());
            String year = sb.toString();
            sb.setLength(0);

            sb.append(arr[4]).append(arr[5]);
            String strMonth = sb.toString();
            int month = Integer.parseInt(sb.toString());
            sb.setLength(0); // 길이를 0으로 만들기 = 가장 빠른 초기화 방법
            sb.append(arr[6]).append(arr[7]);
            String strDay = sb.toString();
            int day = Integer.parseInt(sb.toString());

            if(1<=month && month<=12){
                switch (month){
                    case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 :
                        if(day>31){
                            flag = false;
                        }
                        break;
                    case 2 :
                        if(day>28){
                            flag = false;
                        }
                        break;
                    case 4 : case 6 : case 9 : case 11 :
                        if(day>30){
                            flag = false;
                        }
                        break;
                }
            } else {
                flag = false;
            }
            if(flag){
                System.out.println("#"+i+" "+year+"/"+strMonth+"/"+strDay);
            } else {
                System.out.println("#"+i+" -1");
            }
        }
    }
}

