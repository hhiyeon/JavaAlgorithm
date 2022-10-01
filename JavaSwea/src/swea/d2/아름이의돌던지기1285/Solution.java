package swea.d2.아름이의돌던지기1285;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){
            int N = sc.nextInt();
            for(int i=0; i<N; i++){
                int length = sc.nextInt();
                list.add(Math.abs(length));
            }
            Collections.sort(list);
            int min = list.get(0);
            int count = 0;
            for(int i=0; i<list.size(); i++){
                if(list.get(i)!=min){
                    break;
                } else {
                    count++;
                }
            }
            sb.append('#').append(tc).append(' ');
            sb.append(min).append(' ').append(count);
            if(tc!=T)  sb.append('\n');
        }
        System.out.println(sb);
    }
}

