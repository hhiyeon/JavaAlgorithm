package 코테연습.전화번호목록;

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    static HashSet<String> set = new HashSet<>();
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        set.addAll(Arrays.asList(phone_book));

        for(int i=0; i<phone_book.length; i++){
            for(int j=0; j<phone_book[i].length(); j++){
                if(set.contains(phone_book[i].substring(0,j))){
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String[] p = {"119", "97674223", "1195524421"};
        System.out.println(T.solution(p));
    }
}
