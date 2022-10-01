package swea.d2.스도쿠검증;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    static HashSet<Integer> list = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){
            int[][] arr = new int[9][9];
            boolean flag = true;
            int rowSum = 0;
            int colSum = 0;
            for(int i=0; i<9; i++){
                colSum = 0;
                for(int j=0; j<9; j++){
                    arr[i][j] = sc.nextInt();
                    colSum +=arr[i][j];
                }
                if(colSum!=45){
                    flag = false;
                }
            }

            for(int i=0; i<9; i++){
                rowSum = 0;
                for(int j=0; j<9; j++){
                    rowSum += arr[9-1-j][i];
                }
                if(rowSum!=45) flag = false;
            }

            for(int i=0; i<7; i+=3){
                list.clear();;
                for(int j=0; j<7; j+=3){
                    for(int r=0; r<3; r++){
                        for(int c=0; c<3; c++){
                            list.add(arr[i+r][j+c]);
                        }
                    }
                    if(list.size()!=9){
                        flag = false;
                        break;
                    }
                }
            }
            sb.append('#').append(tc).append(' ');
            if(flag){
                sb.append(1);
            } else {
                sb.append(0);
            }
            if(tc!=T) sb.append('\n');
        }
        System.out.println(sb);
    }
}
