package 코테연습.완전탐색.모의고사;

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        //int[] answer = {};

        // answers = new int[answers.length];

        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[3]; // 맞은 횟수

        for(int i=0; i<answers.length; i++){
            // 0 1 2 3 4 -> 5 % 5, 6 % 5, 7 % 5 ...
            if(p1[i%p1.length] == answers[i]){
                score[0]++;
            }
            if(p2[i%p2.length] == answers[i]){
                score[1]++;
            }
            if(p3[i%p3.length] == answers[i]){
                score[2]++;
            }
        }

        //Arrays.sort(score);
        //int max = score[2]; // 최대값

        int max = 0;
        for(int i=0; i<score.length; i++){
            if(score[i]>max){
                max = score[i];
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<score.length; i++){
            if(max == score[i]){
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

//    public static void main(String[] args) {
//        Solution T = new Solution();
//        int[] answers = {1,2,3,4,5};
//        System.out.println(T.solution(answers));
//    }
}
