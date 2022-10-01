package 코테연습.줄서는방법;

import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = {};
        ArrayList<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();

        for(int i=1; i<=n; i++){
            sb = new StringBuffer();
            sb.append(i).append(" ");
            for(int j=1; j<=n; j++){
                if(i!=j){
                    sb.append(j);
                }
                if(i!=n) sb.append(" ");
            }
            String str = sb.toString();
            list.add(str);
            System.out.println(str);
        }

        String str = list.get((int)k);
        String[] arr = str.split(" ");
        answer = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            answer[i] = Integer.parseInt(arr[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(3,5));
    }
}
