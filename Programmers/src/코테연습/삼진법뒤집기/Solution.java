package 코테연습.삼진법뒤집기;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int answer = 0;

        while(n!=0){
            list.add(n%3);
            n = n/3;
        }

        Collections.reverse(list);
        int multiple = 1;
        for(int i=0; i<list.size(); i++){
            if(i==0){
                answer = list.get(i);
            } else {
                answer = answer + (list.get(i))*multiple;
            }
            multiple = multiple*3;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T =new Solution();
        System.out.println(T.solution(45));
    }
}


//  27 9 3
// 27 + 18