package DataStructure;
/* 요세푸스문제0 - 큐 - 실버4 - 2/18(금)
* 1~N번까지 원이 있을 때
* K번째 순서의 사람 제거해서 (N,K) 순열 구하기
* */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 요세푸스문제0_11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++){
            q.add(i);
        }

        while(q.size()>1){
            int temp;

            for(int i=1; i<K; i++){
                temp = q.poll();
                q.add(temp);
            }
            temp = q.poll();
            sb.append(temp).append(", ");
        }
        sb.append(q.poll());
        System.out.println("<"+sb+">");
    }
}
