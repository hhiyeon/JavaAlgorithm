package 코테연습.행렬의곱셈;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        answer = new int[arr1.length][arr2[0].length];

        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr2[0].length; j++){
                for(int z =0; z<arr1[0].length; z++){
                    answer[i][j] += (arr1[i][z] * arr2[z][j]);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] arr1= {{1,4},{3,2},{4,1}};
        int[][] arr2= {{3,3},{3,3}};
        System.out.println(T.solution(arr1,arr2));
    }
}
