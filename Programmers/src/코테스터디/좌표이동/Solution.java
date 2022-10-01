package 코테스터디.좌표이동;
/* 프로그래머스 라인 백엔드 채용 4번 문제 - 좌표이동 - 2/13(일) 문제인데 2/14(월)에 풀어
 * 2차원 좌표 평면에 다양한 형태의 직사각형
 * 1.직사각형을 아래 방향으로 더 움직일 수 없을 때 까지 이동
 *   - 각 직사각형은 Y축 방향으로만 이동
 * 2. 직사각형을 왼쪽 방향으로 더 움직일 수 없을 때 까지 이동
 *      - X축 방향으로만 이동
 * 마지막으로 각 직사각형의 위치를 배열에 담아 return
 */
import java.util.*;

public class Solution {
    class Point {
        int x1, y1, x2, y2;

        public Point(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
    static ArrayList<Point> list = new ArrayList<>();
    //static Stack<Integer> stack = new Stack<>();
    public int[] solution(int[][] rectangles) {
        int[] answer = new int[rectangles.length];

        // 내림차순 정렬
        Arrays.sort(rectangles, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });

        for(int i=0; i< rectangles.length; i++){
            for(int j=0; j<rectangles[i].length; j++){
            }
        }

        return answer;
    }

    public static int updateHeight(){
        int height = 0;
        return height;
    }

    public static void move(){

    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] rectangles =
                {{0,2,1,3},{1,2,2,5},{3,3,4,4},
                {4,1,6,3},{1,6,5,7},{5,5,7,6},{5,8,6,10}};
        System.out.println(Arrays.toString(T.solution(rectangles)));
    }
}
