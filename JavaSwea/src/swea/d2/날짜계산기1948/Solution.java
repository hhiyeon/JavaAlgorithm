package swea.d2.날짜계산기1948;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for(int i=1; i<=T; i++){
            int count = 0;
            int monthA = sc.nextInt();
            int dayA = sc.nextInt();
            int monthB = sc.nextInt();
            int dayB = sc.nextInt();

            for(int m=monthA; m<=monthB; m++){
                int d = 0;
                switch (m){
                    case 1: case 3 : case 5 : case 7 : case 8 : case 10 : case 12 :
                        d = 31; break;
                    case 2 : d = 28; break;
                    case 4 : case 6 : case 9 : case 11 : d = 30; break;
                }
                if(monthA==monthB){
                    count = dayB - dayA + 1;
                } else {
                    if(m==monthA){
                        count = count + (d-dayA);
                    }
                    else if(m==monthB){
                        count = count + dayB +1;
                    } else {
                        count = count + d;
                    }
                }
            }
            sb.append('#').append(i).append(' ').append(count);
            if(i!=T){
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}

