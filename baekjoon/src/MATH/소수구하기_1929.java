package MATH;

import java.util.ArrayList;
import java.util.Scanner;

public class 소수구하기_1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] arr = new int[N+1];
        if(N<3){

        } else {
            for (int i=M; i<=N; i++) {
                if(arr[i]==0){
                    for(int j=i; j<=N; j=j+i){
                        arr[j] = 1;
                    }
                    sb.append(i).append('\n');
                }
            }
        }

        System.out.println(sb);
    }
}
