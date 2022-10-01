package Bruteforcing;
/*DNA - 브루트포스, 문자열 - 실버5 - 2/5(토)
* 문자열 앞글자만 따기
* 길이가 같은 두 DNA가 있으면
* 글자 다른지 확인하고 다르면 hamming distance 다른 문자 개수 출력
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA_1969 {
    static int N, M; // DNA 수, 문자열 길이
    static String[] dna;
    static int distance = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dna = new String[N];

        for (int i = 0; i < N; i++) {
            dna[i] = br.readLine();
        }

        for (int i = 0; i < M; i++) {
            int[] count = new int[4];
            for (int j = 0; j < N; j++) {
                switch (dna[j].charAt(i)) {
                    case 'A':
                        count[0]++;
                        break;
                    case 'C':
                        count[1]++;
                        break;
                    case 'G':
                        count[2]++;
                        break;
                    case 'T':
                        count[3]++;
                        break;
                }
            }
            int max = 0;
            int idx = 0;
            for(int z = 0; z<4; z++){
                if(max < count[z]){
                    idx = z;
                    max = count[z];
                }
            }

            switch (idx) {
                case 0:
                    sb.append('A');
                    break;
                case 1:
                    sb.append('C');
                    break;
                case 2:
                    sb.append('G');
                    break;
                case 3:
                    sb.append('T');
                    break;
            }
            distance += (N - max);
            //sb.append('\n');
        }
        System.out.println(sb);
        System.out.println(distance);
    }
}
