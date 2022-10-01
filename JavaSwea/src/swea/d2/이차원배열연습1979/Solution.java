package swea.d2.이차원배열연습1979;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){
            int N = sc.nextInt();
            int K = sc.nextInt();
            int count = 0;
            int[][] arr = new int[N][N];

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            for(int i=0; i<N; i++){
                int length = 0;
                for(int j=0; j<N; j++){
                    int color = arr[i][j];
                    if(color==1){
                        length++;
                    } else {
                        if(length==K){
                            count++;
                        }
                        length = 0;
                    }
                }
                if(length==K){
                    count++;
                }
            }
            for(int i=0; i<N; i++){
                int length = 0;
                for(int j=0; j<N; j++){
                    int color = arr[j][i];
                    if(color==1){
                        length++;
                    } else {
                        if(length==K){
                            count++;
                        }
                        length = 0;
                    }
                }
                if(length==K){
                    count++;
                }
            }
            sb.append('#').append(tc).append(' ').append(count);
            if(tc!=T){
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}

