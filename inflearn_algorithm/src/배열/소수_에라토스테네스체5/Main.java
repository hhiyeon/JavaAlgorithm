package 배열.소수_에라토스테네스체5;

import java.util.Scanner;
// 순차적으로 소수 체크를 하다가
// ex. 2가 소수가 아닐 경우 -> 2의 배수들을 모두 아니라고 체크해준다.
public class Main {
    public static int solution(int n){
        int count = 0;
        int[] check = new int[n+1];

        for(int i=2; i<=n; i++){
            if(check[i]==0){
                count++;
                // i의 (j+i)배수들을 체크해준다.
                for(int j=i; j<=n; j=j+i){
                    check[j] = 1;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(T.solution(N));
    }
}
