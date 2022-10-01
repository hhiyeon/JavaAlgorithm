package 코테연습.폰켓몬;

import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int answer = 0;
        int length = nums.length/2;

        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        answer = Math.min(set.size(), length);

        return answer;
    }
}
