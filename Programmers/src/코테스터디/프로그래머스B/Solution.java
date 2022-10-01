package 코테스터디.프로그래머스B;

/* 일단 인접한 배열의 원소들의 차를 모두 구한다.
차이가 k 이하인 것을 확인하고 k 이하일 경우 배열에서 swap의 count 수를 계산한다.
* numbers의 최대 길이가 8이기 때문에 시간 복잡도 문제는 별로 없을 것이라 생각
*/

public class Solution {
    static int compare;
    static int idx;
    static int max;
    static int count = 0;
    public int solution(int[] numbers, int k){
        int answer = 0;
        int element = numbers[0];
        for(int i=1; i<numbers.length; i++){
            compare = Math.abs(element - numbers[i]);
            if(compare > k){
                max = Math.max(element, numbers[i]);
                if(max == numbers[i]){ // swap 원소 구하기
                    idx = i;
                } else {
                    idx = i-1;
                }
            }
            boolean check = false;
            for(int j=0; j<numbers.length; j++){
                int maxCompare = 0;
                if(j!=idx || !check){
                    swap(numbers, numbers[j], numbers[idx]);
                    compare = Math.abs(element - numbers[j]);
                    maxCompare = Math.max(element, numbers[j]);
                    if(compare > k){
                        swap(numbers, numbers[j], numbers[idx]);
                        check = false;
                    } else {
                        check = true;
                    }
                }
                if(maxCompare < k){
                    count++;
                }
            }
        }
        answer = count;
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] numbers = {10, 40, 30, 20};
        int k = 20;
        System.out.println(T.solution(numbers, k));
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
