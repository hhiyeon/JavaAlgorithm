package qString;
/* Hashing - 15829 - 브론즈2 - 문자열
* 해시함수 : 임의의 길이의 입력을 받아서 고정된 길이의 출력을 내보내는 함수
* 입력 : 영문 소문자 26개 각각 1,2,3 .. 26으로 고유한 번호 부여 가능
* ex) abba -> 1,2,2,1
* 수열의 각 항마다 고유한 계수를 부여해준다.
* 항의 번호에 해당하는 만큼 특정한 숫자를 거듭제곱 해서 곱해준 다음 더해준다.
* ex) abcde -> 1*31^0 + 2* 31^1 + 3* 31^2 + 4*31^3 + 5*31^4
* */

import java.util.Scanner;

public class Hashing_15829 {
    static int L;
    static long r = 31;
    static String alphabet;
    static long answer = 0;
    static long pow = 1;
    static int M = 1234567891;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        alphabet = sc.next();

        for(int i=0; i<L; i++){
            answer += (alphabet.charAt(i) - 'a' +1) * pow;
            pow = (pow*=r)%M;
        }
        System.out.println(answer%M);
    }
}
