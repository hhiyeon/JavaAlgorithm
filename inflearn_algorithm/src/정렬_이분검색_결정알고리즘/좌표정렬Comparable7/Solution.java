package 정렬_이분검색_결정알고리즘.좌표정렬Comparable7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// N개의 평면상의 좌표(x,y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램 작성하기
// 정렬 기준은 x값에 의해서 정렬
// x 값이 같을 경우 y 값에 의해 정렬
class Point implements Comparable<Point>{
    public int x, y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public int compareTo(Point o){
        if(this.x==o.x){ // x 값이 같을 경우
            return this.y-o.y;
        } else {
            return this.x - o.x;
        }
    }
}
public class Solution {
    public static int solution(){
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Point> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point(x,y)); // 포인터 객체여서 new로 객체 선언
        }
        Collections.sort(arr); // 리스트의 오름차순 정열
        for(Point o : arr) System.out.println(o.x+" "+o.y);
    }
}
/*
5
2 7
1 3
1 2
2 5
3 6



* */