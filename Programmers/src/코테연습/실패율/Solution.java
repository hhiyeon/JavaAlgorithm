package 코테연습.실패율;
/* 실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어수/ 스테이지에 도달한 플레이어수
실패율이 높은 스테이지부터 내림차순으로 스테이지 번호가 담겨있는 배열 출력
* */
// N=8 , stages=[1,2,3,4,5,6,7]
//result = 7 6 5 4 3 2 1 8
// 8이 가장 마지막에 와야합니다.
//왜? 8스테이지에는 아무도 도달하지 못했기때문에 0이됩니다.
// N = 5
//stages = [2,1,2,4,2,4,3,3]
//
//테스트케이스 한 번 해보세요
//저는 5번 스테이지에 아무도 도달하지 못했을 때 0/0으로 나누게돼서 실패하더라구요

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 전체 스테이지 N, 사용자 멈춰있는 스테이지 stages
        int[] answer = new int[N];
        int[] stopPlayer = new int[N+1]; // 멈춤
        int[] totalPlayer = new int[N+1]; // 총 도전수
        double[][] sortArr = new double[N][2];
        boolean flag = true;

        for(int i=0; i< stages.length; i++){
            if(stages[i]!=N){
                flag = false;
                break;
            }
        }
        if(flag){
            answer = new int[N];
            answer[0] = N;
            for(int i=1; i< answer.length; i++ ){
                answer[i] = i;
            }
            return answer;
        }
        for(int i=0; i<stages.length; i++) {
            int index = stages[i];
            stopPlayer[index - 1]++;
            for (int j = index - 1; j >= 0; j--) {
                totalPlayer[j]++;
            }
        }

        for(int i=0; i<totalPlayer.length-1; i++){
            //System.out.println(stopPlayer[i]+" "+totalPlayer[i]);
            if(totalPlayer[i]==0){
                sortArr[i][0] = 0.0;
                sortArr[i][1] = i+1;
            } else {
                if(stopPlayer[i]==0){
                    sortArr[i][0] = 0.0;
                    sortArr[i][1] = i+1; // stageNumber
                } else if(stopPlayer[i]==totalPlayer[i]){
                    sortArr[i][0] = 1.0;
                    sortArr[i][1] = i+1;
                } else {
                    sortArr[i][0] = (double)stopPlayer[i]/totalPlayer[i];
                    sortArr[i][1] = i+1; // stageNumber
                }
            }
            //System.out.println(sortArr[i][0]+" "+sortArr[i][1]);
        }

//        for(int i=0 ;i<sortArr.length; i++){
//            System.out.println(sortArr[i][0]+ " "+sortArr[i][1]);
//        }

        Arrays.sort(sortArr, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if(o1[0]==o2[0]){
                    return Double.compare(o1[1],o2[1]); // 같으면 오름차순
                } else {
                    return Double.compare(o2[0],o1[0]); // 다르면 내림차순
                }
            }
        });
//        Arrays.sort(sortArr, (o1, o2)->{
//            if(o1[0] == o2[0]){
//                return Double.compare(o2[1],o1[1]);
//            } else {
//                return Double.compare(o2[0],o1[0]);
//            }
//        });

        double comp = sortArr[0][0];
        double compIdx = sortArr[0][1];
        for(int i=1; i<sortArr.length; i++){
            double temp1 = sortArr[i][0];
            double temp2 = sortArr[i][1];
            if(comp==sortArr[i][0] && compIdx>temp2){
                //System.out.println(comp + " "+compIdx);
                sortArr[i][0] = sortArr[i-1][0];
                sortArr[i][1] = sortArr[i-1][1];
                sortArr[i-1][0] = temp1;
                sortArr[i-1][1] = temp2;
            }
            comp = sortArr[i][0];
            compIdx = sortArr[i][1];
        }

        for(int i=0; i<sortArr.length; i++){
            answer[i] = (int)sortArr[i][1];
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int N = 5;
        int[] stages = {2,1,2,6,2,4,3,3};
        System.out.println(Arrays.toString(T.solution(N, stages)));
    }
}
