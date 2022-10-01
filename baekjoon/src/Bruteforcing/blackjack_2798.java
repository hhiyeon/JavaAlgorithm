package Bruteforcing;
/* 블랙잭 2798번 - 브루트포스 - 브론즈2
* 카드의 합이 21을 넘지 않지 않으면서 카드의 합을 최대한 크게 만드는 게임
* 각 카드는 양의 정수
* 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다.
* 그 후 딜러는 숫자 M을 크게 외친다.
* 제한된 시간안에 N장의 카드 중에서 3장의 카드를 고른다.
* 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만든다.
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class blackjack_2798 {
    static int N, M;
    static int[] card;
    static ArrayList<Integer> total = new ArrayList<>();
    static int sum, result;
    static int max;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 카드의 개수
        M = sc.nextInt(); // 카드의 합

        card = new int[N];

        for(int i=0; i<N; i++){
            card[i] = sc.nextInt(); // 각 카드의 숫자
        }

        for(int i=0; i<N; i++){
            sum = 0;
            for(int j=i+1; j<N; j++){
                for(int z=j+1; z<N; z++){
                        sum = card[i] + card[j] + card[z];
                    if(sum == M) {
                        max = sum;
                        break;
                    }
                    else if(max < sum && sum <= M) {
                        max = sum;
                    }
                }
            }
        }
        System.out.println(max);
    }
}

