package etc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
/*
o가 이어지는 개수들 합계 구하기
* */

public class OXquiz_8958 {
    public static void main(String args[]){
        String ox;
        int TC;
        Scanner input = new Scanner(System.in);

        TC = input.nextInt();
        for(int i=0; i<TC; i++){
            int cnt =0;
            int total = 0;
            ox = input.next();
            //String [] oxArr = ox.split("");

            for(int j=0; j< ox.length(); j++){
                    if(ox.charAt(j) =='X'){
                        cnt = 0;
                    } else {
                        cnt++;
                        total = total + cnt;
                    }
                }
            System.out.println(total);
        }
    }
}
