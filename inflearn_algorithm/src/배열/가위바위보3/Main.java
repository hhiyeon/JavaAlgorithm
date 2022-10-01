package 배열.가위바위보3;

public class Main {
    public static String solution(int[] arr1, int[] arr2){
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<arr1.length; i++){
            int A = arr1[i];
            int B = arr2[i];
            if(A==B){
                sb.append("D");
            } else if((A==1&&B==3) || (A==2&&B==1) || (A==3&&B==2)){ // A가 이기는 경우
                sb.append("A");
            } else { // B가 이기는 경우
                sb.append("B");
            }
            if(i!=arr1.length-1) sb.append('\n');
         }
        answer = sb.toString();
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        int[] arr1= {2,3,3,1,3};
        int[] arr2 = {1,1,2,2,3};

        System.out.println(T.solution(arr1, arr2));
    }
}
