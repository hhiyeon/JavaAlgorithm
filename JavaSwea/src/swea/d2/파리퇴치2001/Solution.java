package swea.d2.파리퇴치2001;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] arr = new int[N][N];

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            int max = 0;
            for(int a=0; a<N-M+1; a++){
                for(int b=0; b<N-M+1; b++){
                    int sum=0;
                    for(int c=0; c<M; c++){
                        for(int d=0; d<M; d++){
                            sum += arr[a+c][b+d];
                        }
                    }
                    if(max<sum) max =sum;
                }
            }
            sb.append('#').append(tc).append(' ').append(max);
            if(tc!=T) sb.append('\n');
        }
        System.out.println(sb);
    }
}
