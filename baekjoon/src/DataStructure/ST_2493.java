package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ST_2493 {
    static int N; // N 탑의 개수
    static int popIndex = 0;
    static int height;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            height = Integer.parseInt(st.nextToken());
            if(stack.empty() || stack.peek() < height){
                stack.push(height);
                sb.append(popIndex).append(' ');
            } else if(stack.peek() > height){
                stack.pop();
                popIndex = i;
                sb.append(popIndex).append(' ');
            }
        }
        System.out.println(sb);
    }
}
