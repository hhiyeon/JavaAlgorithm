package 코테스터디.양궁대회;

import java.util.ArrayList;
import java.util.Arrays;

/*
* 어피치가 화살 n발을 다 쏘면 라이언이 화살 n발을 쏜다.
* 점수를 계산한다.
*   - 과녁판은 안쪽부터 10점~0점
*   - 만약 k점(1~10)을 어피치가 a발 라이언이 b발 맞히면
*       - 더 많은 화살을 k점에 맞힌 선수가 k점을 가져간다.
*       - a==b이면 어피치가 k점을 가져간다.
*       - a==b==0이면, 둘다 k점을 가져가지 못한다.
*   - 모든 과녁 점수에 대한 각 선수의 최종 점수를 계산한다.
* 최종 점수가 높은 사람이 우승자.
*   - 최종 점수가 같을 경우 어피치가 우승자.
*
* 현재 상황은 어피치가 화살을 다 쐈고, 라이언이 화살을 쏠 차례
* n : 화살의 개수
* info[] : 어피치가 맞힌 과녁의 점수 개수를 10점부터 0점까지 순서대로 담은 배열
* 라이언이 가장 큰 점수 차이로 우승하기 위해 n발의 화살을 어떤 과녁 점수에 맞혀야 하는지
* 10점~0점 순서대로 정수 배열에 담아서 출력하기
* 라이언이 우승할 수 없으면 -1 출력
* */
class Solution {
    static int[] ryan = new int[11];
    static int[] apeach = new int[11];
    static int[] list = new int[11];
    //static ArrayList<Integer> list = new ArrayList<>();
    static int aScore, rScore;
    static int aTotal, rTotal;
    static int arrowNum;
    static int maxScore = Integer.MIN_VALUE;
    public Object solution(int n, int[] info) {
        //arrowNum = n;

        dfs(0, n, ryan);

        int[] answer;

        if(maxScore == -1){
            return new int[] {-1};
        }

        return Arrays.toString(list);
    }
    public void dfs(int idx, int n, int[] ryan){
        if(n == 0 || idx >= 11){
            if(n>0){
                ryan[10] += n;
            }
            for(int i=0; i<11; i++){
                if(ryan[i]>apeach[i]){
                    rScore+=(10-i);
                } else if(ryan[i]<apeach[i]){
                    aScore+=(10-i);
                }
            }
            int k = rScore-aScore;
            if(k>0){
                if(k==maxScore){
                    if(check()){
                        list = ryan.clone();
                    }
                } else if(k>maxScore){
                    maxScore = k;
                    list = ryan.clone();
                }
            }
            ryan[10] -= n;
            return;
        }
        dfs(idx+1, n, ryan);

        if(n > apeach[idx]){
            ryan[idx] = apeach[idx]+1;
            dfs(idx+1, n-apeach[idx]-1, ryan);
            ryan[idx] = 0;
        }
    }
    public static boolean check(){
        for(int i=10; i>=0; i--){
            if(ryan[i]!=0 && list[i]==0) {
                return true;
            } else if(ryan[i]==0 && list[i]!=0){
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0}; // 10~0점
        System.out.println(T.solution(n,info));
    }
}

