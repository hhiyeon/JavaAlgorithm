package 코테연습.더맵게;

import java.util.*;
//print(solution([1, 1, 1], 4), 2)
//        print(solution([10, 10, 10, 10, 10], 100), 4)
//        print(solution([1, 2, 3, 9, 10, 12], 7), 2)
//        print(solution([0, 2, 3, 9, 10, 12], 7), 2)
//        print(solution([0, 0, 3, 9, 10, 12], 7), 3)
//        print(solution([0, 0, 0, 0], 7), -1)
//        print(solution([0, 0, 3, 9, 10, 12], 7000), -1)
//        print(solution([0, 0, 3, 9, 10, 12], 0), 0)
//        print(solution([0, 0, 3, 9, 10, 12], 1), 2)
//        print(solution([0, 0], 0), 0)
//        print(solution([0, 0], 1), -1)
//        print(solution([1, 0], 1), 1)
class Solution {
    // 스코빌지수가 담긴 배열 scovile, 원하느 스코빌 지수 K
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0; i< scoville.length; i++){
            queue.add(scoville[i]);
        }

        while(queue.peek()<K){
            if(queue.size()==1){
                answer = -1;
                break;
            }
            int element1 = queue.poll();
            int element2 = queue.poll();
            int newElement = element1+(element2*2);
            queue.add(newElement);
            answer++;
        }
        return answer;
    }

     //정수형 내림차순 정렬
    public static int[] IntegerReverseSort(int[] arr){
        Arrays.sort(arr);
        for(int i=0; i<arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
        return arr;
    }


    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {10,10,10,10,10};
        int k= 100;
        System.out.println(T.solution(arr, k));
    }
}