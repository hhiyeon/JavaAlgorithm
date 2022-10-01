package 배열.임시반장정하기11;

import java.util.Scanner;

// 1~5학년동안 같은 반이 많았던 학생을 임시 반장으로 정한다.
//
public class Solution {
    public static int solution(int n, int[][] arr){
        int answer = 0;
        int max = Integer.MIN_VALUE;

        for(int i=1; i<=n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 5; k++) { // 학년
                    if (arr[i][k] == arr[j][k]) {
                        count++;
                        break;
                    }
                }

                if (count > max) {
                    max = count;
                    answer = i;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int[][] arr = new int[n+1][6];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
/**

 2 3 1 7 3
 4 1 9 6 8
 5 5 2 4 4
 6 5 2 6 7
 8 4 2 2 2

 */

        System.out.println(T.solution(5, arr));
    }
}
