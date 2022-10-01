public class quick1 { // first or last
    public static void quickSort(int[] arr){
        sort(arr, 0, arr.length-1);

        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void sort(int[] arr, int low, int high){
        if(low >= high) return;

        int pivot = partition(arr, low, high);
        sort(arr, low, high-1);
        sort(arr, pivot+1, high);
    }

    private static int partition(int[] arr, int low, int high){
        int left = low;
        int right = high;
        int pivot = arr[low];

            while(left < right){
                while(arr[right] > pivot && left < right) right --;
                while(arr[left] <= pivot && left < right) left ++;

                swap(arr, left, right);
        }
            swap(arr, low, left);
            return left;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}