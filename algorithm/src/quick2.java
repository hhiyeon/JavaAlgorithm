import java.util.*;
public class quick2 { // random
    public static void quickSort(int[] arr){
        sort(arr, 0, arr.length-1);

        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void random(int arr[], int low, int high){
        Random rand = new Random();
        int pivot = rand.nextInt(high-low)+low;

        swap(arr, pivot, high);
    }

    private static void sort(int[] arr, int low, int high){
        if(low >= high) return;

        int pivot = partition(arr, low, high);
        sort(arr, low, high-1);
        sort(arr, pivot+1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        random(arr, low, high);
        int pivot = arr[high];
        int i = (low-1);

        for(int j = low; j<high; j++){
            if(arr[j]<pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}