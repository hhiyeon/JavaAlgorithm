package 코테스터디.길찾기게임;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* 방문할 곳의 2차원 좌표 값을 구하고
각 장소를 이진트리의 노드가 되도록 구성한 후,
순회 방법을 힌트로 주어 각 팀이 스스로 경로를 찾도록 할 계획이다.
모든 노드는 서로 다른 x 값을 가진다.
같은 레벨의 노드는 같은 y 좌표를 가진다.
자식 노드의 y 값은 항상 부모 노드보다 작다.
임의의 노드 V의 왼쪽 서브트리에 있는 모든 노드의 x값은 V의 x값 보다 작다.
임의의 노드 V의 오른쪽 서브트리에 있는 모든 노드의 x값은 V의 x값 보다 크다.
이진트리를 구성하는 노드들의 좌표가 담긴 배열 nodeinfo가 매개변수로 주어질 때,
노드들로 구성된 이진트리의 전위 순회, 후위 순회 결과를 2차원 배열에 순서대로 담아 반환하기.
* */
class Solution {
    static ArrayList<Node> nodeList = new ArrayList<>();
    static int idx = 0;
    static int[][] answer;
    public int[][] solution(int[][] nodeinfo) {
        for(int i=0; i<nodeinfo.length; i++){
            nodeList.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i+1, null, null));
        }

        Collections.sort(nodeList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.y == o2.y){
                    return o1.x - o2.x;
                } else {
                    return o2.y - o1.y;
                }
            }
        });

        Node root = nodeList.get(0);

        for(int i=1; i<nodeList.size(); i++){
            binaryTree(root, nodeList.get(i));
        }
        answer = new int[2][nodeList.size()];
        preorder(root);
        idx = 0;
        postorder(root);

        return answer;
    }
    public void binaryTree(Node parent, Node child){
        if(parent.x > child.x){ //
            if(parent.left == null){
                parent.left = child;
            } else {
                binaryTree(parent.left, child);
            }
        } else { // parent.x < child.x
            if(parent.right == null){
                parent.right = child;
            } else {
                binaryTree(parent.right, child);
            }
        }
    }
    public void preorder(Node root){
        if(root!=null){
            answer[0][idx++] = root.value;
            preorder(root.left);
            preorder(root.right);
        }
    }
    public void postorder(Node root){
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            answer[1][idx++] = root.value;
        }
    }

    public class Node{
        int x;
        int y;
        int value;
        Node left;
        Node right;

        public Node(int x, int y, int value, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] nodeinfo = {
                {5,3}, {11,5}, {13,3}, {3,5}, {6,1}, {1,3}, {8,6}, {7,2}, {2,2}
        };
        System.out.println(Arrays.deepToString(T.solution(nodeinfo)));
    }
}
