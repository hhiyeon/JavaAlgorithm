import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때,
// 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.
// 듣도 못한 사람의 수를 set에다 저장한 뒤,
// 보도 못한 사람이 그 set에 들어있는지를 확인해서 들어있다면 출력한다.
//ArrayList로 contains()를 사용할 수도 있지만, 시간초과가 발생한다.
// 시간초과를 잡기 위해서는 HashSet을 사용해야한다.

public class 듣보잡_1764 {
    static int N, M; // 들어보지 못한 사람 수, 보지못한 사람 수
    static String name;
    static HashSet<String> list1 = new HashSet<>();
    static List<String> result = new ArrayList<>();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            name = br.readLine();
            list1.add(name);
        }

        for(int j=0; j<M; j++){
            name = br.readLine();
            if(list1.contains(name)){
                result.add(name);
            }
        }

        count = result.size();
        Collections.sort(result);

        System.out.println(count);
        for(int i=0; i< result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}
