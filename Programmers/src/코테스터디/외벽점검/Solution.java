package 코테스터디.외벽점검;
/* 레스토랑 구조 : 원형
외벽 총 둘레 : n미터
점검 시간 1시간
최소한의 인원이 취약 지점 점검, 나머지 내부 공사
레스토랑 정북 방향 0
취약 지점 위치 : 정북 방향으로부터 시계 방향으로 떨어진 거리
출발지점부터 시계방향, 반시게방향으로만 이동 가능
외벽 길이 : n
취약 지점 위치 배열 : weak
각 친구가 1시간 동안 이동할 수 있는 거리 배열 : dist
취약 지점을 점검하기 위해 보내야 하는 친구 수 최소값을 return
친구를 모두 투입해도 취약지점을 전부 점검하지 못하는 경우 -1 return
* */
import java.util.*;
class Solution {
    static int min = Integer.MAX_VALUE;
    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;

        for(int i=0; i<weak.length; ++i){
            check(n, weak, dist, 1, i, 0);
        }
        if(min == Integer.MAX_VALUE){
            return -1;
        }
        answer = min;
        return answer;
    }

    public static void check(int n, int[] weak, int[] dist, int count, int idx, int visited){
        if(count > dist.length || count >= min){
            return;
        }
        for(int i=0; i<weak.length; ++i){
            int nx = (idx + i) % weak.length;
            int diff = weak[nx] - weak[idx];

            if(nx < idx){
                diff += n;
            }
            if(diff > dist[dist.length-count]){
                break;
            }
            visited |= 1 << nx;
        }
        if(visited == (1 << weak.length) - 1){
            min = count;
            return;
        }
        for(int i=0; i<weak.length; ++i){
            if((visited & (1<<i))!=0){
                continue;
            }
            check(n, weak, dist, count+1, i, visited);
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int n = 12;
        int[] weak = {1,5,6,10};
        int[] dist = {1,2,3,4};
        System.out.println(T.solution(n, weak, dist));
    }
}