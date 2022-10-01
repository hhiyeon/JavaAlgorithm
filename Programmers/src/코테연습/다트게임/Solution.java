package 코테연습.다트게임;

import java.util.ArrayList;

// 다트 게임
// 3번의 기회
// 0~10점
// Single S, Double D, Triple T 영역은 점수마다 하나씩 존재
// 1제곱 2제곱 3제곱
// 옵션 - 스타상 * (해당+바로전 점수2배), 아차상 #(해당점수마이너스)
// 스타상이 처음에 나올 경우 첫번째 점수만 2배
// 스타상은 중첩 가능 -> 4배
// 스타상은 아차상과 중첩 될 수 있다. >> -2배
// 스타상 아차상은 점수마다 둘중 하나만 존재할수있고, 존재하지 않을수도있다.
// 점수 보너스 옵션
class Solution {
    static ArrayList<String> list = new ArrayList<>();
    public int solution(String dartResult) {
        int answer = 0;
        String[] arr = dartResult.split("");
        StringBuilder sb = new StringBuilder();
        String bonus = "";
        String option = "";
        String score = "";
        String input = "";
        int numCount = 0;
        int totalSum = 0;
        int preScore = 0;

        for(int i=0; i<arr.length; i++){
            String s = arr[i];
            if(s.equals("S")||s.equals("D")||s.equals("T")){ // 보너스
                score = sb.toString();
                numCount++;
                bonus = s;
                sb = new StringBuilder();
            } else if(s.equals("*")||s.equals("#")){ // 옵션
                option = s;
            } else {
                if(sb.length()==0&&i!=0){ // 숫자 시작하는 부분에서 데이터 입력
                    if(option.length()==0) {
                        input = score+bonus;
                    } else {
                        input = score+bonus+option;
                    }
                    list.add(input);
                    score="";
                    bonus="";
                    option="";
                }
                sb.append(s);
            }
            if(i== arr.length-1&&numCount>list.size()){
                input = score+bonus+option;
                list.add(input);
            }
        }

        System.out.println(list);

        for(int i=0; i<list.size(); i++){
            String str = list.get(i);
            int numPoint = 0;
            if(str.contains("S")) numPoint = str.indexOf("S");
            if(str.contains("D")) numPoint = str.indexOf("D");
            if(str.contains("T")) numPoint = str.indexOf("T");
            String scoreStr = str.substring(0,numPoint); // 숫자
            int scoreNum = Integer.parseInt(scoreStr);

            if(str.contains("D")) {
                totalSum = scoreNum*scoreNum;
            }
            if(str.contains("T")) {
                totalSum = scoreNum*scoreNum*scoreNum;
            }

            if(str.contains("*")){
                int temp = totalSum;
                if(preScore!=0){
                    totalSum = (preScore*2)+(totalSum*2);
                } else { // 첫번째 경우
                    totalSum = totalSum*2;
                }
                preScore = temp;
            }

            if(str.contains("#")){
                totalSum = (-1)*totalSum;
            }
            System.out.println(scoreStr);


        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T= new Solution();
        String d = "1S2D*3T";
        System.out.println(T.solution(d));
    }
}
