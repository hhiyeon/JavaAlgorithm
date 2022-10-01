package 배열.뒤집은소수6;

import java.util.ArrayList;

public class Main {
    public static String solution(int[] arr){
        StringBuilder res = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        // 정수 한자리씩 쪼개기
//                    1230%10 = 0 -> 1230/10 = 123
//                    123%10 = 3 -> 123/10 = 12
//                    12%10 = 2 -> 12/10 = 1
//                    1%10 = 1 -> 1/10 = 0
        for(int i=0; i<arr.length; i++) {
            int temp = arr[i];
            int answer = 0;
            while (temp > 0) {
                int element = temp % 10;
                answer = answer * 10 + element;
                temp = temp / 10;
            }
//            String str = Integer.toString(number);
//            String[] strArr = str.split("");
//            StringBuilder makeNum = new StringBuilder();
//
//            for(int j= strArr.length-1; j>=0; j--){
//                makeNum.append(strArr[j]);
//            }
//            str = makeNum.toString();
//            arr[i] = Integer.parseInt(str);
//            makeNum.setLength(0); // 초기화

            // 소수인 값을 출력한다.
            if(isPrime(answer)){
                res.append(answer).append(" ");
            }
        }
        return res.toString();
    }
    public static boolean isPrime(int num){
        if(num==1) return false; // 1은 소수가 아니다.
        for(int i=2; i<num; i++){
            if(num%i==0){ // i는 num의 약수가 된다.
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Main T = new Main();
        int[] arr = {32,55,62,20,250,370,200,30,100};
        System.out.println(T.solution(arr));
    }
}
// 23 2 73 2 3
