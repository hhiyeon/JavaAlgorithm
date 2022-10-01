package swea.d2.Base64Decoder1928;

import java.util.Base64;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){
            String encode = sc.next();
            String decode = new String(Base64.getDecoder().decode((encode)));
            sb.append('#').append(tc).append(' ').append(decode);
            if(tc!=T){
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}

