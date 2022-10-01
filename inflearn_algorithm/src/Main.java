import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double N = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int[] arr = new int[(int)N];
        double sum = 0.0;

        for(int i=0; i<N; i++){
            int num = sc.nextInt();
            arr[i] = num;
            max = Math.max(max, num);
        }

        for(int i=0; i<N; i++){
            sum += arr[i]/(double)max*100;
        }
        System.out.println(sum/N);
    }
}
