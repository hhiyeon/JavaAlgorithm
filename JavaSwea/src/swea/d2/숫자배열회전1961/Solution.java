package swea.d2.숫자배열회전1961;

import java.util.Scanner;

public class Solution {
    static int[][] arr90, arr180, arr270;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){
            int N = sc.nextInt();
            arr90 = new int[N][N];
            arr180 = new int[N][N];
            arr270 = new int[N][N];
            int[][] arr = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    int num = sc.nextInt();
                    arr[i][j] = num;
                }
            }
            arr90 = Rotate(arr);
            arr180 = Rotate(arr90);
            arr270 = Rotate(arr180);

            sb.append('#').append(tc).append('\n');
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    sb.append(arr90[i][j]);
                }
                sb.append(' ');

                for(int j=0; j<N; j++){
                    sb.append(arr180[i][j]);
                }
                sb.append(' ');

                for(int j=0; j<N; j++){
                    sb.append(arr270[i][j]);
                }
                sb.append(' ');
                sb.append('\n');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    public static int[][] Rotate(int[][] arr){
        int[][] result = new int[arr.length][arr.length];

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                result[i][j] = arr[arr.length-j-1][i];
            }
        }
        return result;
    }
}

