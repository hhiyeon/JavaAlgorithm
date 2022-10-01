//package 문자열.단어뒤집기4;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
///* N개의 단어가 주어지면 각 단어를 뒤집는 프로그램*/
//public class Main {
//    public ArraysList<String> solution(int n, String[] str){
//        ArraysList<String> answer = new ArrayList<>();
//
//        for(String x : str){
//            String tmp = new StringBuilder(x).reverse().toString(); // x라는 단어를 뒤집은 후 String 객체에 넣어줌
//            answer.add(tmp);
//        }
//
//        return answer;
//    }
//    public static void main(String[] args){
//        Main T = new Main();
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        String[] str = new String[num];
//
//        for(int i=0; i<num; i++){
//            str[i] = sc.next();
//        }
//
//        for(String x : T.solution(num, str)){
//            System.out.println(x);
//        }
//    }
//}
