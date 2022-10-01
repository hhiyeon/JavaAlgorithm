package qString;

import java.io.*;
import java.util.*;

public class NewCharSort_1181 {
    static int N;
    static ArrayList<String> str = new ArrayList<>();
    static String temp = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            str.add(br.readLine());
        }

        Collections.sort(str);

        Collections.sort(str, Comparator.comparing(String::length));

        for(int j=0; j<str.size(); j++){
            if(!temp.equals(str.get(j))){
                System.out.println(str.get(j));
                temp = str.get(j);
            }
        }
    }
}

