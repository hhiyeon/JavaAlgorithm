package 배열.보이는학생2;

import java.util.Scanner;

public class Main {
    public static int solution(int[] arr){
        int answer = 0;
        int maxHeight = arr[0];
        for(int i=1; i<arr.length; i++){
            if(maxHeight<arr[i]){
                answer++;
                maxHeight = arr[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        int[] arr = {130, 135, 148, 140, 145, 150, 150, 153};
        System.out.println(T.solution(arr));
    }
}
