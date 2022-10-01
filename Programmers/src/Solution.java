import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        String[][] arr = new String[][]{{"ab","d"},{"a","cs"},{"aaa","bbd"},{"z","ed"},{"c","z"}};

        // 첫번째 원소 오름차순


                // 첫번째 원소 내림차순
//        Arrays.sort(arr, (o2, o1)->{
//            return o1[0]-o2[0];
//        });
//
//        // 두번째 원소 오름차순
//        Arrays.sort(arr, (o1, o2)->{
//            return o1[1]-o2[1];
//        });
//
//        // 두번째 원소 내림차순
//        Arrays.sort(arr, (o2, o1)->{
//            return o1[1]-o2[1];
//        });

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }
    }
}
