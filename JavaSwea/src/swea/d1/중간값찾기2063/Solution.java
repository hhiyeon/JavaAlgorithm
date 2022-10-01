package swea.d1.중간값찾기2063;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
// 2063 중간값 찾기

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] arr = str.split(" ");
        int[] list = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            list[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(list);

        int medianIdx = num/2;

        System.out.println(medianIdx);
        System.out.println(list[medianIdx]);
    }
}
