package 이분탐색;

import java.util.*;
import java.io.*;
/* 휴게소 세우기 - 이분탐색 - 골드4 - 3/7(월)
N : 고속도로에 있는 휴게소 개수
휴게소의 위치 : 고속도로의 시작으로부터 얼만큼 떨어져 있는지
1. 휴게소는 이미 휴게소가 있는 곳에 세울 수 없다.
2. 고속도로의 끝에 휴게소를 세울 수 없다.
3. 휴게소는 정수 위치에만 세울 수 있다.
휴게소를 M개 더 지어서 휴게소가 없는 구간의 길이의 최대값을 최소값으로 만드는 프로그램
M개의 휴게소를 짓고 난 후 휴게소가 없는 구간의 최대값의 최소값을 출력한다.
*
* */
public class 휴게소세우기_1477 {
    static int N, M, L; // 기존 휴게소 개수, 추가 휴게소 개수, 고속도로 길이
    static ArrayList<Integer> list = new ArrayList<>();
    static int left, right;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        list.add(0);
        list.add(L);

        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list); // O(nlog(n))

        left = 1;
        right = L;
        while(left <= right){
            //System.out.println(left);
            int mid = (left+right)/2;
            int sum = 0;

            for(int i=1; i< list.size(); i++){
                sum += (list.get(i) - list.get(i - 1) - 1) / mid;
            }

            if(sum > M){
                left = mid +1;
            } else {
                right = mid -1;
            }
        }
        System.out.println(left);
    }
}
