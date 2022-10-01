package 코테연습.뉴스클러스터링;
// 자카드 유사도 - 집합 간의 유사도를 검사하는 여러 방법 중의 하나
// J(A, B) : AnB(교집합) 크기 / AUB(합집합) 크기
// A,B가 공집합일 경우 J(A,B) =1
// 다중집합 허용
// 두 글자씩 끊어서 다중집합의 원소로 만든다.
// 영문자 제외 문자들은 모두 버린다. ab+ -> [ab]은 가능, [b+]은 버린다
// 대소문자 구문 없다.

import java.util.*;

class Solution {
    static ArrayList<String> res1 = new ArrayList<>();
    static ArrayList<String> res2 = new ArrayList<>();
    static HashSet<String> set = new HashSet<>();
    public int solution(String str1, String str2) {
        int answer = 0;
        double jacquard = 0;
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        res1 = makeList(str1Arr);
        res2 = makeList(str2Arr);
        double intersection = 0;
        double union = 0;
        // 교집합

        set.addAll(res1);
        set.addAll(res2);

        for (String s: set) {
            int count1 = Collections.frequency(res1, s);
            int count2 = Collections.frequency(res2, s);
            int min = Math.min(count1, count2);
            int max = Math.max(count1, count2);
            intersection += min;
            union += max;
        }

        System.out.println(intersection + " "+ union);

        if(intersection==0 && union==0){
            jacquard = 1;
        } else {
            jacquard = intersection/union;
        }
        jacquard = jacquard*65536;
        answer = (int)jacquard;

        return answer;
    }
    public static ArrayList<String> makeList(char[] str1Arr){
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str1Arr.length; i++){
            if('a'<=str1Arr[i]&&str1Arr[i]<='z'){
                String temp = Character.toString(str1Arr[i]);
                sb.append(temp);
            } else if('A'<=str1Arr[i]&&str1Arr[i]<='Z'){
                String temp = Character.toString(str1Arr[i]); // 문자열 변환
                temp = temp.toLowerCase();
                sb.append(temp);
            } else {
                sb = new StringBuilder();
            }
            if(sb.length()==2){
                list.add(sb.toString());
                sb.deleteCharAt(0);
            }
        }
        System.out.println(list);

        return list;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";
        System.out.println(T.solution(str1, str2));
    }
}