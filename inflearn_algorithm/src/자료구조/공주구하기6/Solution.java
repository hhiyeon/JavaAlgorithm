package 자료구조.공주구하기6;

import java.util.LinkedList;
import java.util.Queue;

// 왕자 N명 나이순서대로 1~N 차례 매김
// 시계 방향으로 둘러 쌓여있고
// 한 왕자가 K(특정숫자) 외치면 그 왕자는 제외
// 그리고 다음 왕자로 부터 다시 1부터 시작해서 번호 외친다.
public class Solution {
    public static int solution(int N, int K){
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;

        for(int i=1; i<=N; i++){
            queue.offer(i);
        }

        while(!queue.isEmpty()){
            for(int j=1; j<K; j++){
                queue.add(queue.poll());
            }
            queue.poll();
            if(queue.size()==1){
                answer = queue.poll();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int N = 8;
        int K = 3;
        System.out.println(T.solution(N,K));
    }
}
