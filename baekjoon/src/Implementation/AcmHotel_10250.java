package Implementation;

import java.util.Scanner;

/*ACM 호텔 - 브론즈 3
* 손님이 도착하는 대로 빈 방 배정
* 정문에서 가장 짧은 거리 방 부터
* 호텔은 직사각형 모양 H 층(세로) * W 개의 방(가로)
* 엘레베이터는 맨 왼쪽
* 호텔 정문은 엘레베이터 바로 옆
* 정문에서 엘레베이터까지의 거리 무시하기
* 방 번호는 YXX 또는 YYXX 형태 - Y 층수 X 엘레베이터와의 거리
* 층은 상관 없지만, 거리가 같은 경우 아래층 선호 102 < 201
* */
public class AcmHotel_10250 {
    static int TC;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        TC = sc.nextInt();

        for(int i=0; i<TC; i++) {
            int H = sc.nextInt(); // 호텔의 층 수
            int W = sc.nextInt(); // 각 층의 방 수
            int N = sc.nextInt(); // 몇 번째 손님인지

            if (N % H == 0) { // H층이 배정 받는 층 수가 0일 경우
                // N / H -> 앞의 호수들을 다 채우고 나오는 몫 (해당 층의 호수)
                System.out.println((H * 100) + (N / H));
            } else {
                System.out.println(((N % H) * 100) + ((N / H) + 1));
            }
        }
    }
}
