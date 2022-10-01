package 코테연습.숫자문자열과영단어;

import java.util.ArrayList;

class Solution {
    public int solution(String s) {
        char[] arr = s.toCharArray();
        StringBuilder temp = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            if('0'<=arr[i]&&arr[i]<='9'){
                list.add(arr[i]-'0'); // 아스키 코드를 이용한 char to int
            } else {
                temp.append(arr[i]);
                if(temp.length()>=3){
                    int num = 10;
                    switch (temp.toString()){
                        case "zero": num = 0; break;
                        case "one": num = 1; break;
                        case "two": num = 2; break;
                        case "three": num = 3; break;
                        case "four": num = 4; break;
                        case "five": num = 5; break;
                        case "six": num = 6; break;
                        case "seven": num = 7; break;
                        case "eight": num = 8; break;
                        case "nine": num = 9; break;
                    }
                    if(num !=10){
                        temp = new StringBuilder();
                        list.add(num);
                    }
                }
            }
        }
        String answer = "";
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
            answer += list.get(i);
        }
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String s = "one4seveneight";
        System.out.println(T.solution(s));
    }
}
