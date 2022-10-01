package swea.d2.두개의숫자열1959;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc =new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=1; i<=T; i++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] arrA = new int[N];
            int[] arrB = new int[M];

            for(int j=0; j<arrA.length; j++){
                arrA[j] = sc.nextInt();
            }

            for (int j=0; j<arrB.length; j++){
                arrB[j] = sc.nextInt();
            }

            int max = 0;

            if(N<M){
                for(int a=0; a<M-N+1; a++){
                    int sum = 0;
                    for(int b=0; b<N; b++){
                        sum = sum + arrA[b]*arrB[a+b];
                    }
                    max = Math.max(max, sum);
                }
            } else if(N>M){
                for(int a=0; a<N-M+1; a++){
                    int sum = 0;
                    for(int b=0; b<M; b++){
                        sum = sum + arrA[a+b]*arrB[b];
                    }
                    max = Math.max(max, sum);
                }
            } else {
                int sum = 0;
                for(int a=0; a<N; a++){
                    sum = sum + arrA[a] * arrB[a];
                }
                max = Math.max(max, sum);
            }
            System.out.println("#"+i+" "+max);
        }
    }
}

