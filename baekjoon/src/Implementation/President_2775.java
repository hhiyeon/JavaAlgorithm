package Implementation;

import java.util.Scanner;

/* 부녀회장이 될테야 - 구현 - 브론즈2
* 아파트 거주 조건
* a층 b호에 살려면 자신의 아래(a-1)층의
* 1호부터 b호까지 사람들의 수 합만큼 사람들을 데려와 살아야 한다.
*
* 비어있는 집은 없고 k층에 n호에는 몇명이 살고있는지 출력
* 아파트는 0층부터 있고, 각층은 1호부터, 0층 i호에는 i명 거주
* */
public class President_2775 {
    static int TC; // 테스트케이스
    static int k,n; // k층 n호
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        TC = sc.nextInt();

        for(int i=0; i<TC; i++) {
            k = sc.nextInt(); // 층 입력
            n = sc.nextInt(); // 호수 입력

            int[][] apart = new int[15][15]; // 아파트 생성

            // 0층 사람 넣기
            for(int j=1; j<=14; j++){
                apart[0][j] = j;
            }
            // 1호에 모두 1명 넣기
            for(int z=0; z<=14; z++){
                apart[z][1] = 1;
            }
            for(int a=1; a<=14; a++){
                for(int b=2; b<=14; b++){
                    apart[a][b] = apart[a][b-1] + apart[a-1][b];
                }
            }
            System.out.println(apart[k][n]);
        }
    }
}

