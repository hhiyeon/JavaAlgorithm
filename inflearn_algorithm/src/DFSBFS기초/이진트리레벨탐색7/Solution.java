package DFSBFS기초.이진트리레벨탐색7;

import java.util.LinkedList;
import java.util.Queue;

// 이진트리 레벨 탐색하기
// 큐 사용
class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data=val;
        lt=rt=null;
    }
}
public class Solution {
    Node root;
    public void BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0; // root 노드 레벨은 0
        while(!Q.isEmpty()){
            int len = Q.size(); // Q의 원소의 개수
            System.out.print(L+" : "); // 해당 레벨의 원소들은 무엇이 있는지 출력
            for(int i=0; i<len; i++){ // 해당 레벨의 원소들이 모두 여기에서 나와야 함
                Node current = Q.poll(); // 노드 꺼내기
                System.out.print(current.data+" ");

                // 왼쪽, 오른쪽 자식을 queue에 넣어줘야 함
                if(current.lt!=null){
                    Q.offer(current.lt);
                }
                if(current.rt!=null){
                    Q.offer(current.rt);
                }
            }
            // for문이 끝나면 레벨 끝
            L++;
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Solution tree = new Solution();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }
}
