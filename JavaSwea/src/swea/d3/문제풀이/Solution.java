package swea.d3.문제풀이;

// 24시간 12368
// 준환이의 운동관리 3431
// 장애물 경주 난이도 6730
// 모음이 보이지 않는 사람 4406
// 거듭제곱 1217


import java.util.Scanner;

public class Solution {
    static int sum = 0;
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        StringBuilder sb= new StringBuilder();
        //int T = sc.nextInt();

        for(int tc=1; tc<=10; tc++){
            sum = 1;
            result = 0;
            int T = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            result = calculation(n, m);

            sb.append('#').append(tc).append(' ').append(result);
            if(tc!=10) sb.append('\n');
        }
        System.out.println(sb);
    }
    public static int calculation(int n, int m){
        if(m!=0) {
            sum = sum * n;
            calculation(n, m - 1);
        }
        return sum;
    }
}
