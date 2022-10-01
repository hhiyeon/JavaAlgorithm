package Greedy;
/* ATM - 그리디 - 11399 - 실버3 - 2/2(수)
 *
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM_11399 {
    static int N;
    static int[] arr;
    static int prev = 0;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int j=0; j<N; j++){
            sum = sum + prev + arr[j];
            prev = prev + arr[j];
        }
        System.out.println(sum);
    }
}
