package Simulation;
/* 마법사 상어와 비바라기 - 구현, 시뮬레이션 - 골드5 - 2/15(화)
* N * N 격자
* (r,c) = 바구니
* A[r][c] = 바구니에 저장되어 있는 물의 양
* 1번행과 N번행, 1번열과 N번열은 이어져있다.
* 방향은 총 8개 방향
* 1. 모든 구름이 d 방향으로 s 칸 이동
* 2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가
* 3. 구름이 모두 사라진다.
* 4. 2에서 물이 증가한 칸 (r,c)에 물 복사버그 마법을 시전한다. 물복사버그 마법을 사용하면,
* 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수 만큼 (r,c)에 있는 바구니의 물이 양이 증가
*  -> 이때 이동과 다르게 경계를 넘어가는 칸은 대각선 방향으로 거리가 1인 칸이 아니다.
*  -> 예를 들어, (N,2)에서 인접한 대각선 칸은 (N-1, 1), (N-1, 3)이고, (N,N)에서 인접한 대각선 칸은 (N-1, N-1) 뿐이다.
* 5. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다.
* 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
* */

import java.io.*;
import java.util.*;
public class Shark_Bibaragi_21610 {
    static class Point{
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M; // N x N 격자 , M 번 이동
    static int[][] map;
    static boolean[][] check;
    static Queue<Point> cloud = new LinkedList<>();
    static int d, s; // 이동의 정보
    static int[] dx = {-1, -1, -1, 0, 1, 1, 0, 1};
    static int[] dy = {-1, 0, 1, 1, 1, -1, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        check = new boolean[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cloud.add(new Point(N-1, 0));
        cloud.add(new Point(N-1, 1));
        cloud.add(new Point(N-2, 0));
        cloud.add(new Point(N-2, 1));

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken())-1;
            s = Integer.parseInt(st.nextToken());

            moveCloud(d, s);
            cross();
            makeCloud();
        }
//        while(M--> 0){
//            st = new StringTokenizer(br.readLine());
//            d = Integer.parseInt(st.nextToken())-1;
//            s = Integer.parseInt(st.nextToken());
//
//            moveCloud(d, s);
//            cross();
//            makeCloud();
//        }
        int answer = 0;
        for(int[] i : map){
            for(int j : i){
                answer += j;
            }
        }
        System.out.println(answer);
    }

            // 1. 모든 구름이 di 방향으로 si칸 이동
            public static void moveCloud(int d, int s){
//        int size = cloud.size();
//
//        for(int i=0; i<size; i++){
//            int[] current = cloud.poll();
//            int x = current[0];
//            int y = current[1];
//            for(int j=0; j<cloud.size(); j++){
//                int tx = p.x + dx[j];
//                int ty = p.y + dy[j];
//
//                if(tx < 0 || tx >= N || ty < 0 || ty >= N && map[tx][ty] !=0) {
//                    count++;
//                }
//                map[p.x][p.y] += count;
//            }
//            list.clear();
//        }
                for(Point p : cloud){
                    p.x = (N + p.x + dx[d] * (s % N)) % N;
                    p.y = (N + p.y + dy[d] * (s % N)) % N;
                    map[p.x][p.y]++; // 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가
                }
            }
            // 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가
//    public static void rain(d, s){
////        int size = cloud.size();
////        for(int i=0; i<size; i++){
////            Point p = cloud.poll();
////            for(int j=0; j<cloud.size(); j++){
////                int tx = p.x + dx[j];
////                int ty = p.y + dy[j];
////        }
//        map[][]
//    }

            // 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수 만큼 (r,c)에 있는 바구니의 물이 양이 증가
            public static void cross(){
                while(!cloud.isEmpty()){
                    Point p = cloud.poll();
                    check[p.x][p.y] = true;
                    int count = 0;

                    for(int j=1; j<=7; j+=2){
                        int tx = p.x + dx[j];
                        int ty = p.y + dy[j];

                        if(tx<0 || ty <0 || tx >= N || ty >= N){
                            continue;
                        }
                        if(map[tx][ty] >0){
                            count++;
                        }
                    }
                    map[p.x][p.y] += count;
                }
//        int size = cloud.size();
//        for(int i=0; i<size; i++){
//            int[] current = cloud.poll();
//            int x = current[0];
//            int y = current[1];
//            int count = 0;
//            for(int j=1; j<=4; j++){
//
//            }
//        }
            }

            // 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다.
            public static void makeCloud(){
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if(map[i][j] >= 2 && !check[i][j]){
                            cloud.add(new Point(i, j));
                            map[i][j] -= 2;
                        }
                    }
                }
                check = new boolean[N][N];
            }
        }


