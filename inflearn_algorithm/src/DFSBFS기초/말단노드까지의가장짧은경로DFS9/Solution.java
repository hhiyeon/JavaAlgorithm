package DFSBFS기초.말단노드까지의가장짧은경로DFS9;
// BFS로도 되는데 DFS로 연습
// 루트에서 말단까지 가는 간선 개수 구하기
class Node {
    int data;
    Node rt;
    Node lt;

    public Node(int val) {
        data = val;
        rt = lt = null;
    }
}
public class Solution {
    Node root;
    public int DFS(int L, Node root){
        if(root.lt==null && root.rt==null){
            return L;
        } else {
            return Math.min(DFS(L+1,root.lt), DFS(L+1,root.rt));
            // 자식이 2개가 아니면 DFS 에서는 말단 노드가 아닌 것이 출력되는 오류가 난다.
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);
        System.out.println(T.DFS(0, T.root));
    }
}
