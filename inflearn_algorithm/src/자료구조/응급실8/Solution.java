package 자료구조.응급실8;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// 위험도가 높은 환자부터 봐줘야 한다.
// 1. 제일 앞의 환자 목록을 꺼낸다
// 2. 뒤에 위험도가 높은 환자 있으면 꺼냈던 환자를 맨 뒤로 보내준다.
// M번째 환자가 진료를 받는 순서 출력
class Person{
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

public class Solution {
    public static int solution(int[] arr, int num){
        Queue<Person> queue = new LinkedList<>();
        int answer = 1;

        for(int i=0; i<arr.length; i++){
            queue.add(new Person(i, arr[i]));
        }

        while(!queue.isEmpty()){
            Person risk = queue.poll();
            for(Person x : queue){
                if(x.priority>risk.priority){ // 뒤에가 위험도가 더 높으면
                    queue.add(risk);
                    risk = null;
                    break;
                }
            }
            if(risk!=null){
                if(risk.id==num){
                    return answer;
                } else {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {60,50,70,80,90};
        int num = 2;
        System.out.println(T.solution(arr, num));
    }
}
