package UnionFInd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 거짓말_1043 {
    static int N, M; // 사람 수, 파티 수
    static int pNum, pIdx; // 진실을 아는 사람수, 각 번호
    static int partyNum, partyIdx; // 각 파티 사람 수, 사람 번호
    static int[] parent;
    static ArrayList<Integer> pList = new ArrayList<>();
    static ArrayList<Integer>[] partyList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        partyList = new ArrayList[M];

        for(int i=1; i<N+1; i++){
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        pNum = Integer.parseInt(st.nextToken());

        if(pNum>0){
            for(int i=0; i<pNum; i++){
                pIdx = Integer.parseInt(st.nextToken());
                pList.add(pIdx);
            }
        } else {
            System.out.println(M);
        }

        for(int i=0; i<M; i++){
            partyList[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            partyNum = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            //int[] arr = new int[partyNum-1];
            for(int j=1; j<partyNum; j++){
                partyIdx = Integer.parseInt(st.nextToken());
                union(x, partyIdx);
                //arr[i] = partyIdx;
                partyList[i].add(partyIdx);
            }
        }

        int count = 0;
        for(int i=0; i<M; i++) {
            boolean flag = true;
            for(int num : partyList[i]) {
                if(pList.contains(find(parent[num]))) {
                    flag= false;
                    break;
                }
            }
            if(flag) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static int find(int a){
        if(parent[a] == a){
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }
}
