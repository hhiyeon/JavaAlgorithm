package 해커랭크.Easy.TimeConversion;

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
    public static String timeConversion(String s) {
        int hour = Integer.parseInt(s.substring(0,2));
        String meridiem = s.substring(s.length()-2);
        StringBuffer answer = new StringBuffer();

        if(meridiem.equals("PM") && hour!=12){
            hour += 12;
        }

        if(hour<10){
            answer.append(0);
            answer.append(hour).append(":");
        } else if (hour==12 && meridiem.equals("AM")){
            answer.append("00").append(":");
        } else {
            answer.append(hour).append(":");
        }
        answer.append(s, 3, s.length()-2);
        //System.out.println(answer);
        return answer.toString();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String result = Result.timeConversion(s);

    }
}

