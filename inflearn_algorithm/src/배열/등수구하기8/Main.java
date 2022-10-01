package 배열.등수구하기8;

public class Main {
    public static int[] solution(int[] arr){
        int[] answer = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            int cnt = 1;
            for(int j=0; j<arr.length; j++){
                if(i!=j){
                    if(arr[i]<arr[j]){
                        cnt++;
                    }
                }
            }
            answer[i] = cnt;
        }

//        for(int i=0; i<answer.length; i++){
//            System.out.print(answer[i]+" ");
//        }
        // 4 3 2 1 5
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        int[] arr = {87,89,92,100,76};
        System.out.println(T.solution(arr));
    }
}
