package etc;

import java.util.Scanner;

/* 대소문자 알파벳 입력 후 가장 많이 사용된 알파벳 알아내서 대문자로 출력하기
* count 할때 대소문자는 구분하지 않는다.
**/
public class wordStudy_1157 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int[] Ascii = new int[26]; // 알파벳 개수 26

        // 대문자로 입력받기
        String captialStr = input.next().toUpperCase();

        int max = -1;
        char ch = '?';

        for (int i = 0; i < captialStr.length(); i++) {
            Ascii[captialStr.charAt(i)-65]++;
            if (max < Ascii[captialStr.charAt(i)-65]) {
                // 65 <= 문자 <= 90 일 경우 (대문자) 문자 + 32
                // 97 <= 문자 <= 122 일 경우 (소문자) 문자 - 32
                max = Ascii[captialStr.charAt(i)-65];
                ch = captialStr.charAt(i);
            } else if(max == Ascii[captialStr.charAt(i)-65]){
                ch = '?';
            }
        }
        System.out.println(ch);
    }
}
