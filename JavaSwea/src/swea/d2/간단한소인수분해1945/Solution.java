package swea.d2.간단한소인수분해1945;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for(int i=1; i<=T; i++){
            int num = sc.nextInt();
            int a = calculation(num, 2);
            int b = calculation(num, 3);
            int c = calculation(num, 5);
            int d = calculation(num, 7);
            int e = calculation(num, 11);
            sb.append("#").append(i).append(' ');
            sb.append(a).append(' ');
            sb.append(b).append(' ');
            sb.append(c).append(' ');
            sb.append(d).append(' ');
            sb.append(e);
            if(i!=T){
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
    public static int calculation(int num1, int num2){
        int count = 0;
        while(num1 % num2 == 0){
            num1 = num1/num2;
            count++;
        }
        return count;
    }
}
