package swea.d2.패턴마디의길이2007;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){
            String str = sc.next();

            for(int i=1; i<=str.length(); i++){
                String pattern = str.substring(0, i);
                String temp = str.substring(i, i+i);
                if(pattern.equals(temp)){
                    sb.append('#').append(tc).append(' ').append(pattern.length());
                    if(tc!=T){
                        sb.append('\n');
                    }
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}