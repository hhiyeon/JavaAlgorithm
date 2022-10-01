package swea.d2.최빈수구하기1204;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb= new StringBuilder();
        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){
            int number = sc.nextInt();
            int maxCount = 0;
            int index = 0;
            int[] arr = new int[101];
            for(int i=0; i<1000; i++){
                arr[sc.nextInt()]++;
            }

            for(int i=0; i<arr.length; i++){
                if(arr[i]>=maxCount){
                    maxCount = arr[i];
                    index = i;
                }
            }
            sb.append('#').append(tc).append(' ').append(index);
            if(tc!=T) sb.append('\n');
        }
        System.out.println(sb);
    }
}
