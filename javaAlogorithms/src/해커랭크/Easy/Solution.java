package 해커랭크.Easy;

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

    public static List<String> bigSorting(List<String> unsorted) {
//        List<BigInteger> sorted = unsorted.stream()
//                .map(BigInteger::new).sorted().collect(Collectors.toList());
//        Collections.sort(sorted);
//        List<String> answer = sorted.stream()
//                .map(String::valueOf)
//                .collect(Collectors.toList());
        Collections.sort(unsorted, (x, y) -> {
            if(x.length() == y.length()){
                return x.compareTo(y);
            } else {
                return x.length() - y.length();
            }
        });
        return unsorted;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> unsorted = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result.bigSorting(unsorted);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
