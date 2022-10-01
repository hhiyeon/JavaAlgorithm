package 그리디.회의실배정2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 1개의 회의실, n개의 회의
// 시간이 겹치지 않게 최대수의 회의 찾기


class Time implements Comparable<Time> {
    public int s, e; // 시작시간, 끝나는시간
    Time(int s, int e){
        this.s = s;
        this.e = e;
    }
    @Override
    public int compareTo(Time o){
        if(this.e==o.e){ // 끝나는시간이 같으면 시간순으로 오름차순
            return this.s-o.s; // 오름차순
        } else {
            return this.e-o.e;
        }
    }
}
public class Solution {
    public int solution(ArrayList<Time> arr, int n){
        int count=0;

        Collections.sort(arr);
        int et = 0;
        for(Time ob : arr){
            if(ob.s>=et){
                count++;
                et = ob.e;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int meet = sc.nextInt();
            int room = sc.nextInt();
            arr.add(new Time(meet, room));
        }
        System.out.println(T.solution(arr, n));
    }
}
