package 코테스터디.기둥과보설치;
import java.awt.*;
import java.util.*;
import java.io.*;

/*
n X n 크기의 가상 벽면
기둥은 바닥 위에 있거나 보의 한쪽 끝 부분 위에 있거나, 또는 다른 기둥 위에 있어야 한다.
보는 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어야 한다.
작업을 수행한 결과가 조건을 만족하지 않으면, 작업은 무시된다.
모든 명령어를 수행한 후 구조물의 상태를 Return
n : 벽면의 크기
build_frame : 기둥 or 보 설치, 삭제 작업
- x,y,a,b : (x,y) 가로 좌표, 세로 좌표
- a 설치 또는 삭제할 구조물의 종류, 0(기둥), 1(보)
- b 구조물을 설치할 지, 혹은 삭제할 지, 0(삭제), 1(설치)
* */
class Solution {
    static ArrayList<info> board = new ArrayList<>();
    static int x,y,a,b;
    public int[][] solution(int n, int[][] build_frame) {
        for(int i=0; i<build_frame.length; i++){
            x = build_frame[i][0];
            y = build_frame[i][1];
            a = build_frame[i][2];
            b = build_frame[i][3];
            info frame = new info(x,y,a);

            if(a == 0 && b == 0){ // 기둥 삭제
                board.remove(frame);
                if(!condition1(board)) {
                    board.add(frame);
                }
            } else if(a == 0 && b == 1) { // 기둥 설치
                board.add(frame);
                if(!condition1(board)){
                    board.remove(board.size()-1);
                }
            } else if(a == 1 && b == 0){ // 보 삭제
                board.remove(frame);
                if(!condition2(board)) {
                    board.add(frame);
                }
            } else { // 보 설치
                board.add(frame);
                if(!condition2(board)) {
                    board.remove(board.size()-1);
                }
            }
        }
        int[][] answer = new int[board.size()][3];
        for(int i=0; i<board.size(); i++){
            info p = board.get(i);
            answer[i][0] = p.x;
            answer[i][1] = p.y;
            answer[i][2] = p.type;
            //System.out.println(answer[i][0]);
        }

        return answer;
    }
    public boolean condition1(ArrayList<info> list){ // 기둥 조건
        boolean flag = false;
        for(info f : list) {
            if (f.y == 0 || list.contains(new info(f.x - 1, f.y, 1))) {
                flag = true;
            }
            if (list.contains(new info(f.x, f.y, 1))) {
                flag = true;
            }
            if (list.contains(new info(f.x, f.y - 1, 0))) {
                flag = true;
            }
        }
        return flag;
    }
    public boolean condition2(ArrayList<info> list){ // 보 조건
        boolean flag = false;
        for(info f : list){
            if(list.contains(new info(f.x, f.y-1, 0))){
                flag = true;
            }
            if(list.contains(new info(f.x+1, f.y-1, 0))){
                flag = true;
            }
            if(list.contains(new info(f.x-1, f.y,1))&&list.contains(new info(f.x+1, f.y,1))){
                flag = true;
            }
        }
        return flag;
    }
    public static class info{
        int x, y, type;

        public info(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }


    public static void main(String[] args) {
        Solution T = new Solution();
        int n = 5;
        int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},
                {5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        System.out.println(T.solution(n, build_frame));
    }
}
