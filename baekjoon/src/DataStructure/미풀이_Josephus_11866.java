package DataStructure;
/* 요세푸스 문제 0 - 자료구조 - 실버4 - 1/25(화)
* N 명의 사람을 k번째 사람을 제거하면서 모두 제거될때 제거되는 순서
*
*
* k 번째 삽입, 삭제 연산에는 연결리스트 사용 -> queue
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 미풀이_Josephus_11866 {
//    static class queue{
//        int front;
//        int rear;
//
//        public queue(int front, int rear) {
//            this.front = front;
//            this.rear = rear;
//        }
//    }
    static int N, K; // 사람 수, 제거하는 위치
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        N = sc.nextInt(); // 사람 수
        K = sc.nextInt(); // 제거 위치

        for (int i = 0; i <N ; i++) {
            queue.add(i+1);
        }

        while(queue.size()>0){
            for(int i=0; i<K-1; i++){
                queue.add(queue.poll()); // 맨 앞의 숫자를 뺀 뒤에 큐(뒤)에 새로 추가한다.
            }
            sb.append(queue.poll());
            if(queue.size()>0){
                sb.append(", ");
            }
        }
        System.out.print("<"+sb+">");
    }
}
