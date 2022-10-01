package etc;/* 직사각형에서 탈출 1085번 - 브론즈3
* 한수 위치 (x,y)
* 직사각형 각 변은 좌표축에 평행
* 왼쪽 아래 꼭짓점 (0,0)
* 오른쪽 위 꼭짓점 (w,h)
* 직사각의 경계선 까지 가는 거리의 최솟값은?
* */

import java.util.Arrays;
import java.util.Scanner;

public class triangleEscape_1085 {
    static int x,y,w,h;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        x = sc.nextInt(); // 위치(x,y)
        y = sc.nextInt();
        w = sc.nextInt(); // 오른쪽 위 꼭짓점(w, h)
        h = sc.nextInt();

        int case1 = x;
        int case2 = y;
        int case3 = h-y;
        int case4 = w-x;

        int[] minArray = new int[4];
        //
        minArray[0] = Math.abs(case1);
        minArray[1] = Math.abs(case2);
        minArray[2] = Math.abs(case3);
        minArray[3] = Math.abs(case4);

        Arrays.sort(minArray);
        System.out.println(minArray[0]);
    }
//    public static double getDistance(int x, int y, int x1, int y1){
//        // Math.sqrt() 제곱
//        // Math.sqrt() 제곱근
//
//        double distance;
//        int xd, yd;
//        yd = (int) Math.pow((y1-y), 2);
//        xd = (int) Math.pow((x1-x), 2);
//        distance = Math.sqrt(yd+xd);
//        return distance;
//    }
}
