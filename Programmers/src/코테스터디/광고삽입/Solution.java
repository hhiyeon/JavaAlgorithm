package 코테스터디.광고삽입;
/* 파란색 선 - 전체 재생 구간
* 검은색 선 - 각 시청자들이 동영상 재생한 구간
* 빨간색 선 - 최적의 공익광고 위치(가장 많이 재생한 구간)
* 누적 재생시간 구하기
* 동영상 재생시간 길이 play_time
* 광고 재생 시간 길이 adv_time
* 시청자 재생 구간 정보 logs
* 누적 재생시간이 가장 많이 나오는 곳 구해서 공익광고 삽입하기
* 공익광고 시작 시각 구해서 return
* 누적 재생시간이 가장 많은 곳이 여러곳일 경우, 가장 빠른 시작 시간 Return
* 360000초 * logs 30만개 */

import java.util.ArrayList;

class Solution {
    static ArrayList<Integer> list = new ArrayList<>();
    static long sum = 0;
    static long max = 0;
    static int maxStart;
    public String solution(String play_time, String adv_time, String[] logs) {
        int playSec = convertTimeToInt(play_time);
        int advSec = convertTimeToInt(adv_time);
        long[] playCnt = new long[playSec+1];

        for(String log : logs){
            String[] temp = log.split("-");
            int start = convertTimeToInt(temp[0]);
            int end = convertTimeToInt(temp[1]);

            for(int time=start; time<end; time++){
                playCnt[time]++;
            }
        }

        for(int i=0; i<advSec; i++){
            sum += playCnt[i];
        }

        max = sum;
        for(int i=advSec; i<playSec; i++){
            sum = sum + playCnt[i] - playCnt[i-advSec];
            if(sum > max){
                max = sum;
                maxStart = i - advSec + 1;
            }
        }

        String answer = convertIntToTime(maxStart);

        return answer;
    }
    public static int convertTimeToInt(String str){
        String[] temp = str.split(":");
        int[] tempInt = new int[temp.length];
        tempInt[0] = Integer.parseInt(temp[0])*60*60;
        tempInt[1] = Integer.parseInt(temp[1])*60;
        tempInt[2] = Integer.parseInt(temp[2]);
        return tempInt[0]+tempInt[1]+tempInt[2];
    }
    public static String convertIntToTime(int sec){
        int hour = sec/3600;
        sec%=3600;
        int min = sec/60;
        sec%=60;
        return String.format("%02d:%02d:%02d", hour, min, sec);
    }
    public static void main(String args[]){
        Solution T = new Solution();
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29",
                "01:30:59-01:53:29", "01:37:44-02:02:30"};
        System.out.println(T.solution(play_time, adv_time, logs));
    }
}
