package 코테연습.오픈채팅방;
// 닉네임 변경법 -> 기존 채팅방에서 출력되어 있던 메시지들도 전부 변경
// 중복 닉네임 허용
// 1. 채팅방을 나가고, 새로운 닉네임으로 다시 들어가기
// 2. 채팅방에서 닉네임 변경
// 최종적으로 보이는 메시지를 출력
import java.util.*;

class Solution {
    static ArrayList<String> list = new ArrayList<>(); // uid + 들어왔습니다
    static ArrayList<String> resList = new ArrayList<>();
    static HashMap<String, String> map = new HashMap<>(); // uid + name
    public String[] solution(String[] record) {
        String[] answer = {};

        for(int i=0; i<record.length; i++){
            String str = record[i];
            String[] strArr = str.split(" ");
            String order = strArr[0];
            String uid = strArr[1];
            if(order.equals("Enter")) {
                String name = strArr[2];
                map.put(uid, name); // 중복 있을경우 갱신
                enterUser(uid);
            }
            if(order.equals("Leave")) {
                leaveUser(uid);
            }

            if(order.equals("Change")) {
                String name = strArr[2];
                map.put(uid, name);
            }
        }
//        for( String key : map.keySet() ){
//            String value = map.get(key);
//            System.out.println( String.format("키 : "+key+", 값 : "+value));
//        }

        for(int i=0; i<list.size(); i++){
            String str = list.get(i);
            int point = str.indexOf("님");
            String listUid = str.substring(0, point);
            String lastName = (String)map.get(listUid);
            String[] arr = str.split(" ");
            String action = arr[1];
            StringBuilder sb = new StringBuilder();
            sb.append(lastName).append("님이 ").append(action);
            resList.add(sb.toString());
        }

        answer = new String[resList.size()];
        for(int i=0; i<resList.size(); i++){
            answer[i] = resList.get(i);
        }
        return answer;
    }
    public static void enterUser(String uid){
        StringBuilder sb = new StringBuilder();
        sb.append(uid).append("님이 들어왔습니다.");
        list.add(sb.toString());
    }
    public static void leaveUser(String uid){
        StringBuilder sb = new StringBuilder();
        sb.append(uid).append("님이 나갔습니다.");
        list.add(sb.toString());
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String[] r = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234",
                "Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(T.solution(r)));
    }
}
