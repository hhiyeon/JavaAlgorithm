package 그리디.씨름선수1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// 키와 몸무게 모두 A 지원자보다 높은 지원자가 존재하면 A 지원자 탈락
// 없으면 A 지원자 선발
// 최대 몇 명 선수 선발할 수 있는지 출력
// 지원자수가 30000명까지 있어서 2중포문 돌리면 X
// 키는 내림차순을 정렬하면 몸무게라도 높아야 탈락 X
class Body implements Comparable<Body>{
    public int h, w;
    Body(int h, int w){
        this.h = h;
        this.w = w;
    }
    @Override
    public int compareTo(Body o){ // h 내림차순
        return o.h-this.h;
    }
}
public class Solution {
    public static int solution(ArrayList<Body> arr, int n){
        int answer = 0;

        Collections.sort(arr); // 내림차순
        int max = Integer.MIN_VALUE;
        for(Body ob : arr){
            if(ob.w>max){
                max = ob.w;
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int height = sc.nextInt();
            int weight = sc.nextInt();
            arr.add(new Body(height, weight));
        }
        System.out.println(T.solution(arr, n));
    }
}
