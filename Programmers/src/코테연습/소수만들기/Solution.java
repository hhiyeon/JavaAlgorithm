package 코테연습.소수만들기;

import java.util.ArrayList;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int z=j+1; z<nums.length; z++){
                    list.add(nums[i]+nums[j]+nums[z]);
                }
            }
        }


        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
            if(primeCheck(list.get(i))) {
                answer++;
            }
        }

        return answer;
    }
    public static boolean primeCheck(int num){
        for(int i=2; i<num; i++){
            if(num%i==0){ // 나눠지는 수가 있을 경우
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] nums = {1,2,3,4};
        System.out.println(T.solution(nums));
    }
}
