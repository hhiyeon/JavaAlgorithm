package SORT;
/*수 정렬하기2 - 2751번 - 실버5
* N 개의 수가 주어졌을 때, 오름차순 정렬
*
* Arrays.sort = o(n^2) 시간복잡도
* 해결 방안
* Collections.sort()를 쓰는 방법
* 얘는 timesort이기 때문에, 합병 및 삽입 정렬을 사용한다. O(nlogn) 보장
*
* StringBuilder 사용
* String과 문자열을 더할 때 새로운 객체 생성이 아닌 기존의 데이터에 더하는 방식
* 속도도 빠르고 부가 적다.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class numberSort2_2751 {
    static int N;
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine()); // N 개의 수

        for(int i=0; i<N; i++){
            int number = Integer.parseInt(br.readLine());
            arr.add(number);
        }

        // Arrays.sort() -> O(n^2)
        Collections.sort(arr); // 합병정렬, 삽입정렬 알고리즘 사용으로 O(nlogn)

//        for(int i=0; i<N; i++){
//            System.out.println(arr.get(i));
//        }

        // String과 문자열을 더할 때 새로운 객체 생성이 아닌 기존의 데이터에 더하는 방식
        for(Integer c : arr){
            sb.append(c).append("\n");
        }

        System.out.println(sb);
    }
}
