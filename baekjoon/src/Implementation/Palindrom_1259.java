package Implementation;
/* 팰린드롬수 1259번 - 문자열, 구현 - 브론즈1
* 팰린드롬 : 어떤 단어를 뒤에서 읽어도 똑같은 단어
* ex) radar, sees, 121, 12421
* 0은 앞에 올 수 없다.
* 팰린드롬이면 yes, 아니면 no 출력
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Palindrom_1259 {
    static String number;
    static char[] array;
    static char[] reverseArray;
    static String answer = "";
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);


        while(true){
            number = sc.next();
            if(number.equals("0")){ // 0 입력되면 종료
                break;
            }
            array = new char[number.length()];
            // 배열 만들기
            for(int i=0; i<number.length(); i++){
                array[i] = number.charAt(i);
            }
            reverseArray = new char[number.length()];
            // 거꾸로된 배열 만들기
            for(int j=0; j<number.length(); j++){
                reverseArray[j] = array[number.length()-1-j];
            }
            for(int z=0; z< array.length; z++){
                if(array[z] == reverseArray[z]){
                    answer = "yes";
                }
                if(array[z] != reverseArray[z]){
                    answer = "no";
                    break;
                }
            }
            System.out.println(answer);
        }
//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(reverseArray));
    }
}
