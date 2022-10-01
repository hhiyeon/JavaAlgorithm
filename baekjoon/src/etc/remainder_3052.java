package etc;

import java.util.ArrayList;
import java.util.Scanner;

/* 입력받은 숫자들의 나머지를 구해서 중복 제거해서 나머지의 개수 구하기 */

public class remainder_3052 {
    public static void main(String args[]){
        int A, remainder;
        ArrayList<Integer> beforeArray = new ArrayList<>();
        ArrayList<Integer> afterArray = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        for(int i=0; i<10; i++){
            A = input.nextInt();

            remainder = A%42;
            beforeArray.add(remainder);
        }

        for(int i=0; i<beforeArray.size(); i++){
            if(!afterArray.contains(beforeArray.get(i)))
                // contain 함수를 사용하여 값을 포함하는지 확인
                // ArrayList.get(int index) 인자로 인덱스를 받는다. 인덱스의 객체 리턴
                afterArray.add(beforeArray.get(i));
        }
        System.out.println(afterArray.size());
    }
}
