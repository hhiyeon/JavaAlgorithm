package swea.d2.가랏RC카1940;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int commandN = sc.nextInt();
            int speed = 0;
            int distance = 0;
            for (int n = 1; n <= commandN; n++) {
                int num = sc.nextInt();
                if(num==1){
                    speed += sc.nextInt();
                } else if(num==2){
                    speed -= sc.nextInt();
                } else if(num==0){
                }
                if(speed<0){
                    speed = 0;
                }
                distance += speed;
            }
            sb.append('#').append(tc).append(' ').append(distance);
            if(tc!=T){
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}
