package MATH;

import java.util.Arrays;
import java.util.Scanner;

/* 시험 성적 최대값 찾고 계산 다시해서 평균 구하기 */

public class average_1546 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        int N = input.nextInt(); // 시험 본 과목의 개수
        double[] score = new double[N];
        // double compare = 0;
        double sum = 0;

        for(int i=0; i<N; i++){ // 시험 점수
            score[i] = input.nextInt(); // 시험 성적 입력
//            if(i==0){
//                compare = score[i];
//            } else{
//                if(score[i-1]<score[i]){ // 최대값 찾기
//                    compare = score[i];
//                }else{
//                    compare = score[i-1];
//                }
//            }
        }
        Arrays.sort(score); // 오름차순 정렬

        // 오름차순 정렬 후에 배열의 마지막 원소가 최대 값
        for(int j=0; j<score.length; j++){
                sum += (score[j]/score[score.length-1])*100;
        }
        System.out.println(sum/score.length);
    }
}
