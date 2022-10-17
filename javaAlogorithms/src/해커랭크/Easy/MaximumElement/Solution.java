package 해커랭크.Easy.MaximumElement;

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
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<Integer> getMax(List<String> operations) {
        // Write your code here
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < operations.size(); i++) {
            String element = operations.get(i);
            if (element.length()>1) {
                String[] tmp = element.split(" ");
                int parseNum = Integer.parseInt(tmp[1]);
                stack.add(parseNum);
                if(maxStack.isEmpty() || parseNum >= maxStack.peek()){
                    maxStack.add(parseNum);
                }
            }else {
                if (element.equals("2")) {
                    int delValue = stack.pop();
                    if (delValue == maxStack.peek()) {
                        maxStack.pop();
                    }
                }
                if (element.equals("3")) {
                    answer.add(maxStack.peek());
                }
            }
        }
        return answer;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<Integer> res = Result.getMax(ops);

        bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
