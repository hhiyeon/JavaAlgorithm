package DataStructure;
/* 큐 - 자료구조 - 실버4 - 1/22(토)
* push X : 정수를 큐에 넣기
* pop : 큐에서 가장 앞의 정수 빼고, 그 수 출력. 없으면 -1 출력
* size : 큐에 들어있는 정수 개수 출력
* empty : 큐가 비어있으면 1, 아니면 0 출력
* front : 큐의 가장 앞의 정수 출력. 정수 없으면 -1 출력
* back : 큐의 가장 뒤의 정수 출력. 정수 없으면 -1 출력
* */

import java.io.IOException;
import java.util.Scanner;

public class Queue_10845 {
    static int N;
    static String order;
    static int[] queue;
    static int frontIndex = 0;
    static int backIndex = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt(); // 명령의 개수
        queue = new int[N]; // 큐의 크기 선언

        for(int i=0; i<N; i++){
            order = sc.next(); // 명령 입력

            if(order.contains("push")){
                int param = sc.nextInt();
                push(param);
            }
            if(order.contains("pop")) {
                sb.append(pop()).append('\n');
            }
            if(order.contains("size")) {
                sb.append(size()).append('\n');
            }
            if(order.contains("empty")) {
                sb.append(empty()).append('\n');
            }
            if(order.contains("front")) {
                sb.append(front()).append('\n');
            }
            if(order.contains("back")) {
                sb.append(back()).append('\n');
            }
        }
        System.out.println(sb);
    }

    // 정수를 큐에 넣기
    public static void push(int num){
//        if(size == 0){
//            queue[size] = num;
//        } else {
//            for(int i=size; i>=1; i--){
//                queue[size] = queue[size-1];
//                queue[size-1] = 0;
//            }
//            queue[0] = num;
//        }
//        size++;
        queue[backIndex] = num;
        backIndex++;

    }

    // 가장 앞의 정수 빼고, 출력. 없으면 -1 출력
    public static int pop(){
//        if(size == 0){
//            return -1;
//        } else {
//            int popNum = queue[size-1];
//            queue[size-1] = 0;
//            size--;
//            return popNum;
//        }
        if(backIndex-frontIndex ==0){
            return -1;
        } else {
            int popNum = queue[frontIndex];
            frontIndex++;
            return popNum;
        }
    }

    // 정수의 개수 출력
    public static int size(){
        return backIndex-frontIndex;
    }

    // 비어있으면 1 아니면 0 출력
    public static int empty(){
        if(backIndex-frontIndex==0){
            return 1;
        } else {
            return 0;
        }
    }

    // 가장 앞의 정수 출력. 없으면 -1 출력
    public static int front(){
        if(backIndex-frontIndex==0){
            return -1;
        }else{
            return queue[frontIndex];
        }
    }

    // 가장 뒤의 정수 출력. 없으면 -1 출력
    public static int back(){
        if(backIndex-frontIndex==0){
            return -1;
        } else {
            return queue[backIndex-1];
        }
    }
}
