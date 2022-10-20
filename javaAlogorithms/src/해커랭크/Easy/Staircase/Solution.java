package 해커랭크.Easy.Staircase;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static void staircase(int n) {
        Consumer<Integer> consumer = num -> {
            for(int i=0; i<num; i++) {
                for(int j=0; j<num; j++){
                    if(i+j >= n-1) {
                        System.out.print('#');
                    }else{
                        System.out.print(' ');
                    }
                }
                System.out.println();
            }
        };
        consumer.accept(n);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}
