package 코테연습.비밀지도;

import java.util.Arrays;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb =new StringBuilder();
        int temp = 1;

        if(n==1){
            temp =1;
        } else {
            for(int i=1; i<n; i++){
                temp = temp*2;
            }
        }
        //System.out.println(temp);
        // 1 2 4 8 16

        for(int i=0; i< arr1.length; i++){
            String binaryNum1 = "";
            String binaryNum2 = "";
            if(arr1[i]<temp){
                binaryNum1 = Integer.toBinaryString(arr1[i]);
                for(int j=0; j<n-binaryNum1.length(); j++){
                    sb.append("0");
                }
                binaryNum1 = sb.toString()+Integer.toBinaryString(arr1[i]);
                sb = new StringBuilder();
            } else {
                binaryNum1 = Integer.toBinaryString(arr1[i]);
            }

            if(arr2[i]<temp){
                binaryNum2 = Integer.toBinaryString(arr2[i]);
                for(int j=0; j<n-binaryNum2.length(); j++){
                    sb.append("0");
                }
                binaryNum2 = sb.toString()+Integer.toBinaryString(arr2[i]);
                sb = new StringBuilder();
            } else {
                binaryNum2 = Integer.toBinaryString(arr2[i]);
            }

            String[] strArr1 = binaryNum1.split("");
            String[] strArr2 = binaryNum2.split("");
            sb = new StringBuilder();

            for(int j=0; j<strArr2.length; j++){
                if(strArr1[j].equals("0")&&strArr2[j].equals("0")){
                    sb.append(" ");
                } else if(strArr1[j].equals("1")||strArr2[j].equals("1")){
                    sb.append("#");
                }
            }

            System.out.println(sb);
            answer[i] = sb.toString();
            sb = new StringBuilder();
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};
        System.out.println(Arrays.toString(T.solution(n, arr1, arr2)));
    }
}