package etc;

import java.util.Scanner;

/* 음계 오름차순 내림차순 섞인 순서 구분하기 */

public class scale_2920 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int[] scale = new int[8];
        String result = ""; // 문자열 초기화

        for(int i=0; i<8; i++){
            scale[i] = input.nextInt();
        }

        for(int j=1; j<8; j++){
            if(result.equals("ascending") && scale[j-1]>scale[j]){
                result = "mixed";
                break;
            } else if(result.equals("descending") && scale[j-1]<scale[j]){
                result = "mixed";
                break;
            } else {
                if(scale[j-1]<scale[j]){
                    result = "ascending";
                }
                else {
                    result = "descending";
                }
            }
        }
        System.out.println(result);
    }
}
