package swea.d1.간단한N의약수1933;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        divisor(num);
        Collections.sort(list);

        for (int i=0; i<list.size(); i++){
            System.out.print(list.get(i));
            if(i!=list.size()-1){
                System.out.print(' ');
            }
        }
    }
    public static void divisor(int num){
        for(int i=1; i<=num; i++){
            if(num%i==0){
                list.add(i);
            }
        }
    }
}
