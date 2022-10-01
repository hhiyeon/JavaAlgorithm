package 코테연습.체육복;

import java.util.Arrays;

class Solution { // 전체학생수 n, 도난당한 학생 번호 lost, 여벌 체육복 있는 학생 번호 reserve
    // 체육 수업을 들을 수 있는 학생 수의 최대값을 구해라
    // 필요한 체육잔여 인덱스 구한다음에 2인거 찾아내서 왼쪽이나 오른쪽에 잔여체육복 있는지 확인하기
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int possibleCount = n-lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i]==reserve[j]){
                    possibleCount++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        for(int j=0; j<lost.length; j++){
            for(int i=0; i<reserve.length; i++){
                if(lost[j]-1==reserve[i] || lost[j]+1==reserve[i]){
                    possibleCount++;
                    reserve[i] = -1;
                    break;
                }
            }
        }

        answer = possibleCount;
        return answer;
    }

    public static void main(String[] args) {
        Solution T =new Solution();
        int n = 5;
        int[] l = {2, 4};
        int[] r = {1,3,5};
        System.out.println(T.solution(n,l,r));
    }
}