package 해커랭크.Easy.PlusMinus;

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

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        double plus = 0;
        double minus = 0;
        double zero = 0;
        double size = arr.size();
        for(int i=0; i<size; i++){
            if(arr.get(i)>0){
                plus++;
            }else if(arr.get(i)==0){
                zero++;
            }else{
                minus++;
            }
        }
        double[] result = new double[3];
        result[0] = plus/size;
        result[1] = minus/size;
        result[2] = zero/size;

        for(int i=0; i<3; i++){
            System.out.printf("%.6f", result[i]);
            System.out.println();
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
