package 코테연습.두개뽑아서더하기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static List<Integer> list = new ArrayList<>();
    public int[] solution(int[] numbers) {
        int[] answer = {};

        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                if(i!=j){
                    int sum = numbers[i]+numbers[j];
                    set.add(sum);
                    System.out.println(sum);
                }
            }
        }

        answer = new int[set.size()];

        list.addAll(set);
        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] n = {2,1,3,4,1};
        System.out.println(T.solution(n));
    }
}
