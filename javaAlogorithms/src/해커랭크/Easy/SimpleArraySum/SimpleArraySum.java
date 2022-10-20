package 해커랭크.Easy.SimpleArraySum;

import java.io.*;
import java.util.*;

class Result {
    public static int simpleArraySum(List<Integer> ar) {
        int answer = ar.stream().mapToInt(i -> i).sum();
        return answer;
    }
}

public class SimpleArraySum {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        int arCount = Integer.parseInt(bufferedReader.readLine().trim());

//        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());

        List<Integer> ar = new ArrayList<>();

        for(int i=1; i<=3; i++){
            ar.add(i);
        }

        int result = Result.simpleArraySum(ar);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

