package 코테연습.완전탐색.소수찾기;

import java.util.*;
/* 흩어진 숫자들을 붙여서 소수 몇 개 만들 수 있는지
* numbers : 숫자가 적힌 문자열
* 013 -> 0, 1, 3
* 만들 수 있는 수를 모두 만든 후 소수 판별
* */

class Solution {
    static boolean[] visited;
    static char[] arr;
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        //List<Integer> list = new ArrayList<>();
        //int[] token = new int[numbers.length()];

        arr = new char[numbers.length()];
        visited = new boolean[numbers.length()];

        // 한 자리씩 쪼개기
        for(int i=0; i<numbers.length(); i++){
            arr[i]=numbers.charAt(i);
        }

        recursion("", 0);
        answer = set.size();

        return answer;
    }

    public void recursion(String str, int idx){
        int num;
        if(str!=""){
            num = Integer.parseInt(str);
            if(isPrime(num)){
                set.add(num);
            }
        }
        if(idx == arr.length){
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            recursion(str+arr[i], idx+1);
            visited[i] = false;
        }
    }
    public static boolean isPrime(int num){
        if(num==1 || num==0){
            return false;
        }
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String numbers = "17";
        //String numbers = "011";
        System.out.println(numbers);
    }
}
