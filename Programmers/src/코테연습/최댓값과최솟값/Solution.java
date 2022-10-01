package 코테연습.최댓값과최솟값;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int[] arrInt = new int[arr.length];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++){
            int number = Integer.parseInt(arr[i]);
            arrInt[i] = number;
            min = Math.min(min, arrInt[i]);
            max = Math.max(max, arrInt[i]);
        }

        answer = min+ " "+max;
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("-1 -2 -3 -4"));
    }
}
