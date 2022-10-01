import java.util.*;
public class insertion {
    public static void insertion_sort(int[] arr){
        insertion_sort(arr, arr.length);
    }
    private static void insertion_sort(int[] arr, int size){
        for (int i=1; i<size; i++){
            int key = arr[i]; // 키 값
            int j = i-1;

            while(j>=0 && key <arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void insertion_print(int[] arr){
        for (int i = 0; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
