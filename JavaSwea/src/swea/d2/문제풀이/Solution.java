package swea.d2.문제풀이;

// 지그재그숫자 1986
// 수도 요금 경쟁 1284
// 초심자의 회문 검사 1989 = 펠린드롬
// 숫자를 정렬하자 1966 : 오름차순, 리스트 사용
// 사각 덧셈 1976
// 간단한 369게임 1926
// 쉬운 거스름돈 1970
// 간단한 압축풀기 1946
// 중간 평균값 구하기 1984

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        StringBuilder sb= new StringBuilder();
        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){
            String str = sc.next();
            String[] arr = str.split("");
            sb.append('#').append(tc).append(' ');
            for(int i=0; i<arr.length; i++){
                String s = arr[i];
                if(s.equals("a")||s.equals("e")||s.equals("i")||s.equals("o")||s.equals("u")){
                    continue;
                } else {
                    sb.append(s);
                }
            }
            if(tc!=T) sb.append('\n');
        }
        System.out.println(sb);
    }
}