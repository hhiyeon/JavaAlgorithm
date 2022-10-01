package 코테스터디.불량사용자;
/* HashSet에 들어가는 객체들은 반드시 equals()와 hashCode() 메소드를 구현해야 하는데,
이 메소드들을 가지고 HashSet에 들어갈 때 중복된 객체가 있는지 여부를 체크하게 된다.
public boolean add(Object o) 메소드는 set에 데이터를 집어넣을 때 사용되는데,
성공적으로 추가되면 true를, 중복된 객체가 들어오면 false를 리턴한다.

user_id : 응모자 아이디 목록 // 1~8
banned_id : 불량 사용자 아이디 목록 // 1~8
제제 아이디 목록 경우의 수 구하기 return

불량 사용자들을 정규 표현식으로 변환한 다음
유저 목록 idx 와 불량 사용자 idx가 일치하는 것을 DFS로 반복

중복된 애들을 제거하기 위해서 최종적으로 만들어진 SET에서 관리하는 SET을 만들어 중복 제거
* */

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    static HashSet<String> resultSet = new HashSet<>();
    static String[] regex;
    static boolean[] visited;

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        regex = new String[banned_id.length];
        visited = new boolean[user_id.length];
        for (int i = 0; i < banned_id.length; i++) {
            regex[i] = banned_id[i].replace("*", ".");
        }

        dfs(user_id, banned_id, 0, "");
        answer = resultSet.size();

        return answer;
    }

    public static void dfs(String[] user_id, String[] banned_id, int idx, String str) {
        if (idx == banned_id.length) {
            String[] strArr = str.split(" ");
            Arrays.sort(strArr);

            String resStr = "";
            for (int i = 0; i < strArr.length; i++) {
                resStr += strArr[i];
            }
            resultSet.add(resStr);
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (user_id[i].matches(regex[idx]) && !visited[i]) {
                visited[i] = true;
                dfs(user_id, banned_id, idx + 1, str + " " + user_id[i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        //String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        //String[] banned_id = {"fr*d*", "abc1**"};

        //String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        //String[] banned_id = {"*rodo", "*rodo", "******"};

        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
        System.out.println(T.solution(user_id, banned_id));
    }
}
