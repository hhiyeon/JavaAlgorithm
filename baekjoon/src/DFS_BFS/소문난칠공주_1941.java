package DFS_BFS;
/*소문난 칠공주 - dfs, bfs - 골드3 - 3/5(토)
* 총 25명 여학생반 5 X 5 자리 형태
* 규칙 1. 7명의 여학생
* 2. 7명의 자리는 서로 가로나 세로로 반드시 인접
* 3. 이다솜파만 구성될 필요는 없다.
* 4. 이다솜파가 우위를 점해야 한다. (이다솜파는 7명중 4명 이상)
* 소문난 칠공주를 결성할 수 있는 모든 경우의 수를 구하기*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class 소문난칠공주_1941 {
    static char[][] map = new char[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int[] array = new int[7];
    static int count;
    static int[] nx = {1, -1, 0, 0};
    static int[] ny = {0, 0, 1, -1};
    static int[] combX = new int[25];
    static int[] combY = new int[25];
    static boolean[] check = new boolean[25];
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        for(int i=0; i<5; i++) {
//            String str = br.readLine();
//            map[i] = str.toCharArray();
//        }
//
//        for(int i=0; i<25; i++){
//            int x = i/5;
//            int y = i%5;
//            visited[x][y] = true;
//            check[i] = true;
////            if(map[i]){
////
////            }
//        }
////        for(int i=0; i<25; i++) {
////            combX[i] = i % 5;
////            combY[i] = i / 5;
////        }
//
//        dfs(0, 0, 0);
//    }
//    public static void dfs(int idx, int count, int memS){
//        if(count == 7){
//            if(memS >= 4){
//                result += bfs();
//            }
//            return;
//        }
//        for(int i=idx; i<25; i++){
//            array[count] = i;
//            visited[i/5][i%5] = true;
//            dfs();
//            visited[i/5][]
//        }
//    }
//    }
//    public static int bfs(){
////        Queue<Integer> q= new ArrayDeque<>();
////        count = 1;
////        q.add()
////
////    }
////    public static void comb(){
////
////    }
//}
    }
}