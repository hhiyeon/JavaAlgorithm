package swea.d3.이십사시간;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int hour = A+B;

            while(true){
                if(hour>23){
                    hour = hour-24;
                } else {
                    sb.append('#').append(tc).append(' ').append(hour);
                    break;
                }
            }
            if(tc!=T) sb.append('\n');
        }
        System.out.println(sb);
    }
}
