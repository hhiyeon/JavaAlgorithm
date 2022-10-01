package DataStructure;
/* 제로 - 실버4 - 스택, 구현 - 1/23(일)
잘못된 수를 부를때마다 0 외쳐셔, 가장 최근에 재민이가 쓴 수 지움
재민이는 이렇게 모든 수를 받아 적고 그 수의 합을 알고싶어 한다.
* */
import java.util.Scanner;
import java.util.Stack;

public class Zero_10773 {
    static int K;
    static int num = 0;
//    static ArrayList<Integer> arr = new ArrayList<>();
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();

        for(int i=0; i<K; i++){
            num = sc.nextInt();

            if(num==0){
                stack.remove(stack.size()-1);
            }
            else {
                stack.push(num);
            }
        }

        int sum =0 ;

        while (!stack.empty()) {
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
