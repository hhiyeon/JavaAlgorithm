package SORT;
/* 나이순 정렬 - 정렬 - 실버5 - 1/25(화)
 * 나이, 이름 - 가입한 순서대로
 * 1. 나이가 증가하는 순
 * 2. 나이가 같으면 가입순
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AgeSort_10814 {
    public static class people {
        int age;
        String name;

        public people(int age, String name) {
            super();
            this.age = age;
            this.name = name;
        }

    }

    static int N;
    static int age;
    static String name;
    static ArrayList<people> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            age = Integer.parseInt(st.nextToken());
            name = st.nextToken();
            arr.add(new people(age, name));
        }

        Collections.sort(arr, new Comparator<people>() {
            @Override
            public int compare(people o1, people o2) {
                return o1.age - o2.age;
            }
        });

        for(int i=0; i<N; i++){
            sb.append(arr.get(i).age).append(' ');
            sb.append(arr.get(i).name).append('\n');
        }

        System.out.println(sb);
    }
}
