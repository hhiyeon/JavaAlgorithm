package swea.d2.조교의성적매기기1983;

import java.util.*;

public class Solution {
    static HashMap<Integer, Double> map = new HashMap<>();
    static ArrayList<Double> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++){
            int N = sc.nextInt();
            int K = sc.nextInt();

            for(int i=1; i<=N; i++){
                int midScore = sc.nextInt();
                int finalScore = sc.nextInt();
                int hwScore = sc.nextInt();
                double totalScore = 0.0;

                totalScore = (midScore*0.35)+(finalScore*0.45)+(hwScore*0.20);
                map.put(i, totalScore);
                list.add(totalScore);
            }
            for(int i=0; i<list.size(); i++){
                System.out.println(list.get(i));
            }

            Collections.sort(list);
            double findScore = map.get(K);
            String[] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
            int count = 1;

            for(int i=0; i<list.size(); i++){
                if(list.get(i)==findScore){
                    sb.append('#').append(tc).append(' ');
                    sb.append(grade[10-count]);
                    break;
                } else {
                    count++;
                }
            }
            if(tc!=T) sb.append('\n');

//            Object[] mapKey = list.keySet().toArray();
//            Arrays.sort(mapKey);
//            String[] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
//            int count = 1;
//            for(Double nKey : list.keySet()){
//                if(list.get(nKey)==K){
//                    sb.append('#').append(tc).append(' ');
//                    sb.append(grade[count]);
//                    break;
//                } else {
//                    count++;
//                }
//            }
            if(tc!=T) sb.append('\n');
        }
        System.out.println(sb);
    }
}
