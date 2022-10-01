package qString;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 단어 정렬 1181번 - 문자열 - 실버5
*  알파벳 소문자로 이루어진 N 개의 단어가 들어오면 정렬
*  1) 길이가 짧은 것 부터
*  2) 길이가 같으면 사전 순으로
* */
public class charSort_1181 {
    static int N;
    static String[] str;
    static String temp = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 단어의 개수

        str = new String[N];
        //length = new int[N];

        for(int i=0; i<N; i++){
            str[i] = br.readLine();
            //length[i] = str[i].length();
        }

        // 문자열 오름차순 정렬
        Arrays.sort(str);
        // 길이 순으로 정렬
        Arrays.sort(str, Comparator.comparing(String::length));

        for(int j=0; j<str.length; j++){
            if(temp.equals(str[j])){ // 문자가 같은 경우 출력 X
                continue;
            } else{ // 문자가 같지 않은 경우 출력
                System.out.println(str[j]);
                temp = str[j];
            }
        }
    }
}
