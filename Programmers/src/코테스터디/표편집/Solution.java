package 코테스터디.표편집;
/* 한 번에 한 행만 선택 가능, 표의 범위(0~마지막) 벗어날 수 없음
* U X : 현재 선택된 행에서 X칸 위에 있는 행 선택
* D X : 현재 선택된 행에서 X칸 아래에 있는 행 선택
* C : 현재 선택된 행을 삭제하고, 바로 아래행 선택(삭제된 행이 마지막이면 바로 윗행 선택)
* Z : 가장 최근에 삭제된 행을 복구.(현재 선택된 행은 수정X)
* 삽입 삭제가 용이한 연결 리스트 이용
* 가장 최근에 삭제된 행 복구 -> 스택 사용
* */

import java.util.Stack;

public class Solution {
    public class Node {
        Node data;
        Node next;
        boolean removed;
    }
    public String solution(int n, int k, String[] cmd) {
        Node[] nodeArr = new Node[n];
        Stack<Node> s = new Stack<>();

        for(int i=0; i<n; i++){
            nodeArr[i] = new Node();
        }
        for(int i=0; i<n-1; i++){
            nodeArr[i+1].data = nodeArr[i];
            nodeArr[i].next = nodeArr[i+1];
        }

        Node current = nodeArr[k];

        for(String str : cmd){
            char command = str.charAt(0);
            if(command == 'U'){ // 현재 선택된 행에서 X칸 위에 있는 행 선택
                int num = Integer.parseInt(str.substring(2));
                for(int i=0; i<num; i++){
                    current = current.data;
                }

            } else if (command == 'D'){ // 현재 선택된 행에서 X칸 아래에 있는 행 선택
                int num = Integer.parseInt(str.substring(2));
                for(int i=0; i<num; i++){
                    current = current.next;
                }

                // 현재 선택된 행을 삭제하고, 바로 아래행 선택(삭제된 행이 마지막이면 바로 윗행 선택)
            } else if(command == 'C'){
                s.push(current);
                current.removed = true; // 삭제 체크
                Node up = current.data;
                Node down = current.next;
                if(up != null){ // 아래행 선택
                    up.next = down;
                }
                if(down != null){ // 마지막행 삭제일 경우 바로 위의 행 선택
                    down.data = up;
                    current = down;
                }

                // 가장 최근에 삭제된 행을 복구.(현재 선택된 행은 수정X)
            } else if(command == 'Z'){
                Node reStoreNode = s.pop();
                reStoreNode.removed = false;
                Node up = reStoreNode.data;
                Node down = reStoreNode.next;

                if(up != null){
                    up.next = reStoreNode;
                }
                if(down != null){
                    down.data = reStoreNode;
                }
            }
        }

        StringBuilder answer = new StringBuilder();

        for(int i=0; i<n; i++){
            if(nodeArr[i].removed){
                answer.append('X');
            } else {
                answer.append('O');
            }
        }
        return answer.toString();
    }
}
