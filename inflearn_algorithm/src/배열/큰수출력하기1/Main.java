package 배열.큰수출력하기1;
/* N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램
* 6
* 7 3 9 5 6 12 -> 7 9 6 12
* */

import java.util.Scanner;

public class Main {
    public int[] solution(int num, int[] arr){
        int[] answer = new int[num];
        answer[0] = arr[0];

        for(int i=1; i<num; i++){
            if(arr[i]>arr[i-1]){
                answer[i] = arr[i];
            }
        }
        // 0 빼고 출력해야 함
        return answer;
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); // 숫자 개수
        int[] arr = new int[num];

        for(int i=0; i<num; i++){
            arr[i] = sc.nextInt();
        }
        for(int x : T.solution(num, arr)){
            System.out.println(x+" ");
        }

    }
}

//package 배열;
//// N(1<=N<=100)개의 정수를 받아서
//// 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램 작성
//// 첫 번째는 무조건 출력
//public class Solution {
//    public String solution(int[] arr){
//        String answer = "";
//        StringBuilder sb= new StringBuilder();
//        int preNum = arr[0];
//        for(int i=0; i<arr.length; i++){
//            if(i==0){
//                sb.append(arr[i]).append(" ");
//            } else {
//                if(preNum<arr[i]){
//                    sb.append(arr[i]).append(" ");
//                }
//                preNum = arr[i];
//            }
//        }
//        answer = sb.toString();
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        배열.Solution T = new 배열.Solution();
//        int[] arr = {7,3,9,5,6,12};
//        System.out.println(T.solution(arr));
//    }
//}
