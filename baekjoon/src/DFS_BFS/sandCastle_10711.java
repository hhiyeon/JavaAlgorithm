package DFS_BFS;

/* 모래성 - BFS - 골드3 - 2/14(월)
해수욕장 이름 ALPS
- 모래성 2차 격자단위
- 각 격자는 튼튼한 정도가 다르다. 1부터 9까지
- 격자 주변 8방향에서 모래성이 쌓여있지 않은 부분의 개수가
자기 모래성의 튼튼함보다 많거나 같은 경우 파도에 의해 무너질 수 있다.
무너지면 그 격자는 모래성이 쌓여있지 않은 것으로 취급
모래성이 더 이상 모양이 변하지 않으려면 파도가 몇번 쳐야하는지 구하기
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sandCastle_10711 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int H, W; // 모래성의 가로 세로
    static char[][] map;
    static boolean[][] visit; // 모래가 없는 곳
    static int[] dx = {-1, -1, -1, 0, 1, 1, 0, 1};
    static int[] dy = {-1, 0, 1, 1, 1, -1, -1, 0};
    static Queue<Point> Q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        visit = new boolean[H][W];

        for(int i=0; i<H; i++){
            String str = br.readLine();
            for(int j=0; j<W; j++){
                map[i][j] = str.charAt(j);
                if(str.charAt(j) == '.'){
                    Q.offer(new Point(i,j));
                    // visit[i][j] = true;
                }
            }
        }
        BFS();
        System.out.println(sb);
    }
    public static void BFS(){
        int count = 0;
        while(!Q.isEmpty()){ // 큐에 값이 없다 = 더이상 변화 X
            int size = Q.size();
            for(int i=0; i<size; i++){ // 연결된 곳을 순회
                Point p = Q.poll(); // 맨 앞 값을 경로 p에 저장
                //int x = p.x;
                //int y = p.y;
                for(int j=0; j<8; j++){
                    int tx = p.x + dx[j]; // 꺼낸 값 보다 상하좌우 x좌표
                    int ty = p.y + dy[j]; // 꺼낸 값 보다 상하좌우 y좌표
                    if(tx >= 0 && ty >= 0 && tx < H && ty < W){
                        // 공간에서 벗어나지 않는 애들만 수행
                        if(map[tx][ty]!='.'){
                            map[tx][ty]--;
                            if(map[tx][ty]=='0'){
                                map[tx][ty] = '.';
                                Q.offer(new Point(tx, ty));
                            }
                        }
                        //map[tx][ty] = 1; // 익은 토마토를 1으로 체크하고
                        //Q.offer(new Point(ty, tx)); // 큐에 익은 토마토 경로를 넣는다.
                        //day[tx][ty] = day[p.x][p.y]+1; // 이전의 날짜에서 +1을 더해 현재 경로에 날짜를 넣어준다.
                    }
                }
            }
            count++;
        }
        count--;
        sb.append(count);
    }
}
