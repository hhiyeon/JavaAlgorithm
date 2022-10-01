package DataStructure;
/* 스택 - 자료구조 - 실버4 - 1/22(토)
* 스택 구현 후 삽입, 삭제, 정수 개수출력, 비어있는지, 맨위 출력
* push X, pop, size, empty, top
* */

import java.util.Scanner;

public class Stack_10828 {
    static int N;
    static String order;
    static int[] stack; // 스택선언
    static int input;
    static int size = 0;

    public static void main(String[] args) { // psv
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();

        stack = new int[N];
        //input = new String[2];

        for (int i = 0; i < N; i++) {
            order = sc.next();

// int intNum = input[1] - '0'; // char to int
// int intNum = Integer.parseInt(input); // string to int

            if (order.contains("push")) {
                input = sc.nextInt();
                push(input);
            }

            if (order.contains("pop")) {
                sb.append(pop()).append('\n');
            }

            if (order.contains("size")) {
                sb.append(size()).append('\n');
            }

            if (order.contains("empty")) {
                sb.append(empty()).append('\n');
            }

            if (order.contains("top")) {
                sb.append(top()).append('\n'); // 객체에 값 넣기 + 엔터
            }

        }
        System.out.println(sb);
        // StringBuilder 클래스는 String 클래스와 유사
        // String은 불변하지만 StringBuilder 가변적
        // String은 메모리 내부에서 변경 불가능
        // StringBuilder은 문자열 결합 등의 액션 수행할때 새로운 문자열 추가 X -> 기존 문자열에 추가
        // toString을 쓰는 경우 새로운 객체가 생길 수도 있다.
    }
        private static void push(int x){ // 삽입
            // 정수 X 에 스택 넣기
            // top에 있는 수를 밑으로하고 넣은 값을 top으로 변경
            stack[size] = x;
            size++;
        }

        private static int pop () { // 가장 위 삭제하고 출력, 정수 없으면 -1 출력
            if (size == 0) {
                return -1;
            } else {
                int topNumber = stack[size - 1];
                stack[size - 1] = 0;
                size--;
                return topNumber;
            }
        }
        private static int size () { // 정수 개수 출력
            return size;
        }

        private static int empty () { // 비어있는지 체크 -> 비어있음 1, 아님 0
            if (size == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        private static int top () { // 가장 위의 정수 출력
            if (size == 0) {
                return -1;
            } else {
                return stack[size - 1];
            }
        }
    }
