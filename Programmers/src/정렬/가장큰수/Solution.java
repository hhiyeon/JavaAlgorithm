package 정렬.가장큰수;
import java.util.*;

/* 정수를 이어 붙여서 만들 수 있는 가장 큰 수 */

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        String[] strNumbers = new String[numbers.length];

        // int -> string 배열 변경
        for(int i=0; i<numbers.length; i++){
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        // 두 수를 번갈아가면서 합친 수들 중에 큰 값을 앞으로 정렬(내림차순 정렬)
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        // 첫번째 값이 0 이면 = 0 값이 중복일 경우 0 리턴
        if(strNumbers[0].equals("0")){
            return "0";
        }

        // 0이 아니면 문자열을 더해준다.
        for(String s: strNumbers){
            answer += s;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int numbers[] = {6, 10, 2};
        //int numbers[] = {3, 30, 34, 5, 9};

        System.out.println(T.solution(numbers));
    }
}
