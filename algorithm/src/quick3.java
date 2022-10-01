public class quick3 { // median
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

    private static int partition(int[] arr, int low, int high) {
        int left = low - 1;
        int right = high + 1;
        int pivot = arr[(left + right) / 2];

        while (true) {
            do {
                left++;
            } while (arr[left] < pivot);
            do {
                right--;
            } while (arr[right] > pivot && left <= right);

            if (left >= right) {
                return right;
            }
            swap(arr, left, right);
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
