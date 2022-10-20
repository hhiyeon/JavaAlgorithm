package 해커랭크.Easy.SolveMeFirst;

import java.util.*;
import java.util.function.BinaryOperator;

public class Solution {


    static int solveMeFirst(int a, int b) {
        BinaryOperator<Integer> sum = (n1,n2) -> n1+n2;
        int res = sum.apply(a, b);
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        a = in.nextInt();
        int b;
        b = in.nextInt();
        int sum;
        sum = solveMeFirst(a, b);
        System.out.println(sum);
    }
}
