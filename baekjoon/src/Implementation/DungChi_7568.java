package Implementation;
/*덩치 7568번 실버5 - 구현, 브루트포스
* 덩치 = 키, 몸무게 비교 -> 몸무게 x, 키 y -> 덩치 (x,y)
* A와 B를 비교할때, 키 몸무게 둘다 크면 덩치가 크다.
* 하지만 하나씩 크면 비교할 수 없다.
*
* N명의 집단에서 각 사람의 덩치 등수 = 자신보다 큰 덩치의 사람 수
* 큰 사람이 k명 이라면 k+1이 내 등수
* */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class DungChi_7568 {
    static int N;
    static int[][] info;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 사람의 수

        info = new int[N][2];

        for (int i = 0; i < N; i++) {
            info[i][0] = sc.nextInt(); // 몸무게
            info[i][1] = sc.nextInt(); // 키
        }

        for(int i=0; i< N; i++){
            int rank = 1;
            for(int j=0; j< N; j++){
                if(i == j){ // 키와 몸무게 등수 같을 경우
                    continue;
                }
                if(info[i][0] < info[j][0] && info[i][1] < info[j][1]){
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}
