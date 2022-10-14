package 코딜리티.Easy.SimpleArraySum;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    public static int simpleArraySum(List<Integer> ar) {
        // Write your code here
        int sum = 0;
        for(int i=0; i<ar.size(); i++){
            sum += ar.get(i);
        }
        return sum;
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

