package SORT;
/* 수 정렬하기 3 - 정렬 - 실버5 - 1/23(일)
N개의 수 오름차순
메모리 문제
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class numberSort3_10989 {
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
//            arr.add(Integer.parseInt(br.readLine()));
            arr[i] = Integer.parseInt(br.readLine());
        }

//        Collections.sort(arr);
        Arrays.sort(arr);

        for(int i=0; i<N; i++){
//            sb.append(arr.get(i)).append('\n');
            sb.append(arr[i]).append('\n');
        }

        System.out.println(sb);
    }
}
