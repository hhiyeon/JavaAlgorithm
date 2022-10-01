package swea.d1.연월일달력2056;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=1; i<=T; i++){
            StringBuilder sb = new StringBuilder();
            boolean flag = true;
            String str = sc.next();
            char[] arr = str.toCharArray();

            for(int j=0; j<4; j++){
                sb.append(arr[j]);
            }
            //int year = Integer.parseInt(sb.toString());
            String year = sb.toString();
            sb.setLength(0);

            sb.append(arr[4]).append(arr[5]);
            String strMonth = sb.toString();
            int month = Integer.parseInt(sb.toString());
            sb.setLength(0); // 길이를 0으로 만들기 = 가장 빠른 초기화 방법
            sb.append(arr[6]).append(arr[7]);
            String strDay = sb.toString();
            int day = Integer.parseInt(sb.toString());

            if(1<=month && month<=12){
                switch (month){
                    case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 :
                        if(day>31){
                            flag = false;
                        }
                        break;
                    case 2 :
                        if(day>28){
                            flag = false;
                        }
                        break;
                    case 4 : case 6 : case 9 : case 11 :
                        if(day>30){
                            flag = false;
                        }
                        break;
                }
            } else {
                flag = false;
            }
            if(flag){
                System.out.println("#"+i+" "+year+"/"+strMonth+"/"+strDay);
            } else {
                System.out.println("#"+i+" -1");
            }
        }
    }
}


