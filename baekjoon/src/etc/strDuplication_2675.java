package etc;

import java.util.Scanner;

/* 원소별로 문자 중복 시켜서 출력하기 */
public class strDuplication_2675 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int TC, duplication;

        TC = input.nextInt();

        for(int i=0; i<TC; i++){
            String S;

            duplication = input.nextInt();
            S = input.next();
            // nextLine()을 사용하면 공백까지 읽기 때문에 next() 사용

//            String[] strArr = S.split("");

            for(int j=0; j<S.length(); j++){
                for(int z=0; z<duplication; z++){
                    System.out.print(S.charAt(j));
                }
            }
            System.out.println(); // 안하면 틀려
        }
    }
}
