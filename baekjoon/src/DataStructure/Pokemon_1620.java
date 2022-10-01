package DataStructure;
/* 나는야 포켓몬 마스터 이다솜 - 해시맵 - 실버4 - 1/25(화)
* 포켓몬 이름을 보면 포켓몬 번호를 말하거나
* 포켓몬 번호를 보면 포켓몬의 이름을 말하기기
*
* 포켓몬 개수 N
* 내가 맞춰야 하는 문제의 개수 M
* N, M 은 자연수
*
* 포펫몬 이름 : 첫 글자 대문자 + 나머지 소문자 but 마지막 문자만 대문자 일수도 있음
* 포켓몬 도감 입력 후
*
* 총 M 개의 줄에 맞춰야 하는 문제가 들어온다.
* 알파벳이 들어오면 포켓몬 번호
* 숫자로 들어오면 포켓몬 번호에 해당하는 문자 출력하기
*
* 일단 도감을 채우는건 포켓몬의 개수 N 번
* 맞춰야 하는 문제 M * 포켓몬 개수 N => N^2
*
* 해시나 트리를 이용하면 O(1) 또는 O(logN) 시간복잡도로 구할 수 있을 것이라는 생각
* 시간이 2초로 짧은 시간이 주어지니 해시로 풀어보고 key, value로 이루어진 맵으로 진행해보자.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Pokemon_1620{
    static int N, M; // 포켓몬 개수, 문제 개수
    static String name;
    static String question; // 질문
    static boolean type;
    static HashMap<Integer, String> IntKey = new HashMap<>();
    static HashMap<String, Integer> StrKey = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken()); // 포켓몬 개수
        M = Integer.parseInt(st.nextToken());  // 문제 개수

        // 해시맵 도감 생성
        for(int i=1; i<=N; i++){
            name = br.readLine(); // 포켓몬 이름
            IntKey.put(i, name);
            StrKey.put(name, i);
        }

        // 문제 풀이
        for(int j=1; j<=M; j++){
            question = br.readLine();

            type = typeCheck(question);

            if(type){ // 숫자일 경우
                sb.append(IntKey.get(Integer.parseInt(question))).append('\n');
            } else { // 문자열일 경우
                sb.append(StrKey.get(question)).append('\n');
            }
        }
        System.out.println(sb);
    }

    public static boolean typeCheck(String str) {
        try{
            Double.parseDouble(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
