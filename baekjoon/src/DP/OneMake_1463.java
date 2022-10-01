package DP;
/* 1로 만들기 - DP - 실버3 - 2/3(목)
*
* */
//import java.io.*;
//import java.util.*;
//
//public class Main {
//    static int num;
//    static int dp[];
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        num = sc.nextInt();
//        dp = new int[num+1];
//
//        dp[0] = dp[1] = 0;
//        for(int i=2; i<=num; i++){
//            dp[i] = dp[i-1] + 1;
//            if(i % 3 == 0) {
//                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
//            }
//            if(i % 2 == 0){
//                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
//            }
//        }
//        System.out.println(dp[num]);
//    }
//}


import java.util.*;

public class OneMake_1463 {
    public int solution(int num){
        int answer = 0;
        int dp[] = new int[num+1];
        dp[0] = 0;
        dp[1] = 0;

        for(int i=2; i<=num; i++){
            dp[i] = dp[i-1] + 1;
            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        answer = dp[num];
        return answer;
    }
    public static void main(String[] args){
        OneMake_1463 T = new OneMake_1463();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(T.solution(num));
    }
}