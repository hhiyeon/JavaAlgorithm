public class heap {
    static int heapsize;
    static int compcount;
    private static void BuildHeap(int arr[]) {
        compcount = 0;
        heapsize = arr.length;

        for (int i = (heapsize) / 2; i >= 0; i--) {
            MaxHeapify(arr, i);
        }
    }
    private static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void HeapSort(int arr[]){
        BuildHeap(arr);

        for(int i = arr.length-1; i>=0; i--){
            swap(arr, 0, i);
            heapsize = heapsize -1;
            MaxHeapify(arr, 0);
        }

        for(int i=0; i<arr.length; i++){ // print
            System.out.print(arr[i] + " ");
        }
    }
    private static void MaxHeapify(int arr[], int i){
        compcount ++;
        int left = (i*2)+1;
        int right = (i*2)+2;
        int largest = i;

        if(left < heapsize && arr[left] > arr[largest]){
            largest = right;
        }
        if(largest != i){
            swap(arr, i, largest);
            MaxHeapify(arr, largest);
        }
    }
}
