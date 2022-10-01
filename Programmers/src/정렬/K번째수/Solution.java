package 정렬.K번째수;

import java.util.*;

/* array에서 i번째부터 j번째까지 자르고 생긴 배열에서
정렬하고
k 번째 수 출력하기
commands : i, j, k
*
* */
public class Solution {
    public int[] solution(int[] array, int[][] commands){
        int[] answer = new int[commands.length];

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<commands.length; i++){
            int first = commands[i][0]-1;
            int last = commands[i][1]-1;
            int find = commands[i][2]-1;
            for(int j=first; j<=last; j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[i] = list.get(find);
            list.clear();
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[3][3];
        commands[0] = new int[]{2, 5, 3};
        commands[1] = new int[]{4, 4, 1};
        commands[2] = new int[]{1, 7, 3};

        System.out.println((T.solution(array, commands)));
    }
}

/*
* for(int i=0; i<commands.length; i++){
            // commands의 길이만큼 a,b,c 값 넣어주기
            int a,b,c;
            a = commands[i][0];
            b = commands[i][1];
            c = commands[i][2];

            // copyOfRange(원본배열, 시작인덱스, 마지막인덱스+1)
            // 같은 타입의 복사된 새로운 배열 반환
            int[] temp = Arrays.copyOfRange(array, a-1, b);
            // array를 받아서 내가 입력받은 command i~j, k로
            // a-1번째부터 b까지 복사 배열 만들기
            Arrays.sort(temp); // 복사 배열을 오름차순으로 정렬하기
            answer[i] = temp[c-1]; // 정렬 배열에서 k번째(c-1) 값을 answer 에 넣기
        }
        return answer;
* */