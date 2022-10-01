package DFSBFS기초.말단노드까지의가장짧은경로BFS10;

import java.util.LinkedList;
import java.util.Queue;

// BFS 말단 노드 최초로 발견되는애가 가장 짧은 경로의 말단 노드
class Node{
    int data;
    Node rt;
    Node lt;

    public Node(int val){
        data = val;
        rt = lt = null;
    }
}

public class Solution {
    Node root;
    public int BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root); // 큐에 루트 넣어준다.
        int L = 0; // 레벨은 0 부터
        while(!Q.isEmpty()){
            int len = Q.size(); // 레벨에 있는 원소 개수 = 큐의 사이즈
            for(int i=0; i<len; i++){
                Node current = Q.poll(); // 현재 (레벨) 큐에 있는 원소들
                if(current.lt==null && current.rt == null){
                    return L; // 말단노드의 경우 출력
                }
                // 자식 노드가 있는 경우 현재 노드의 자식 노드를 큐에 넣어준다.
                if(current.lt!=null){
                    Q.offer(current.lt);
                }
                if(current.rt!=null){
                    Q.offer(current.rt);
                }
            }
            // for문이 끝남 = 레벨 증가
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);
        System.out.println(T.BFS(T.root));
    }
}
