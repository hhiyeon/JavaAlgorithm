public class merge {
    public static void merge_sort(int arr[]){
        merge_divide(arr, 0, arr.length-1); // 원소를 반으로 나누는 함수

        merge_print(arr); // 정렬된 배열 출력
    }

    private static void merge_divide(int[] arr, int left, int right) {
        if (left < right) {// 원소의 수가 2개 이상일 경우
            int mid = (left + right) / 2;

            merge_divide(arr, left, mid); // 왼쪽 재귀
            merge_divide(arr, mid + 1, right); // 오른쪽 재귀
            merge_combine(arr, left, mid, right); // merge
        }
    }

    private static void merge_combine(int[] arr, int left, int mid, int right){
        int i = left;
        int j = mid+1;
        int temp_index = left;

        int[] temp = new int[arr.length];

        while(i <= mid && j <= right){
            if(arr[i]<arr[j]) {
                temp[temp_index++] = arr[i++];
            }else{
                temp[temp_index++] = arr[j++];
            }
        }
        while(i <= mid){    // 왼쪽 배열에 원소가 남은 경우
            temp[temp_index++] = arr[i++];
        }
        while(j <= right){  // 오른쪽 배열에 원소가 남은 경우
            temp[temp_index++] = arr[j++];
        }
        for(int index = left; index <= temp_index; index++){
            arr[index] = temp[index];
        }
    }

    private static void merge_print(int[] arr){
        for(int i =0; i <arr.length; i++){
            System.out.print(arr[i]+"");
        }
        System.out.println();
    }
}
