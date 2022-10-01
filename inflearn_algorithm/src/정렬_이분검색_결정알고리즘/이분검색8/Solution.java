package 정렬_이분검색_결정알고리즘.이분검색8;

// 임의의 N개의 숫자가 입력으로 주어진다.
// N개의 수를 오름차순으로 정렬하고, 다음 N개의 수 중에서
// 1개의 수인 M이 주어지면, 이분 검색으로 M이 정렬된 상태에서
// 몇 번째에 있는지 구하는 프로그램 작성하기. 중복값 X
import java.util.Arrays;
import java.util.Scanner;
public class Solution {
    public static int solution(int n, int m, int[] arr){
        int answer = 0;
        Arrays.sort(arr);
        int lt = 0;
        int rt = n-1;

        while(lt<=rt){ // 왼쪽이 오른쪽으로 가면 해제
            int mid = (lt+rt)/2;
            if(arr[mid]==m){
                answer = mid+1;
                break;
            } else if(arr[mid]<m){ // 왼쪽
                lt = mid +1;
            } else if(arr[mid]>m){ // 오른쪽
                rt = mid -1;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 수 개수
        int m = sc.nextInt(); // 구하는 수
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            arr[i] = num;
        }
        System.out.println(T.solution(n,m,arr));
    }
}
