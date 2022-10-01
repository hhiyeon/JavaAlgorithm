package DataStructure;
/* 탑 - 자료구조, 스택 - 골드 5 - 1/24(월)
* N 개의 높이가 서로 다른 탑
* 왼쪽으로 레이저 신호를 발사
* 높이가 낮으면 수신 불가능
* stack.peek 최근에 추가된 top 데이터 조회
*
* 생각
* 조건에 맞는 index를 출력하는 문제
* 스택을 순서대로 넣으면서
* 조건에 맞게 push pop 한다.
* 조건 : 현재 값보다 다음 값이 더 작을 경우(수신성공) Pop
* 수신 성공된 index 갱신
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackTop_2493 {
    static class topInfo {
        int index; // 탑의 번호
        int height; // 탑의 높이

        public topInfo(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
    static int N; // N 탑의 개수
    static int h;
    static Stack<topInfo> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            h = Integer.parseInt(st.nextToken());
            while(!stack.empty()){
                if (stack.peek().height > h) {
                    sb.append(stack.peek().index).append(' ');
                    stack.push(new topInfo(i, h));
                    break;
                } else if (stack.peek().height < h) {
                    stack.pop();
                }
            }
            if (stack.empty()) {
                stack.push(new topInfo(i, h));
                sb.append('0').append(' ');
            }
        }
        System.out.println(sb);
    }
}

