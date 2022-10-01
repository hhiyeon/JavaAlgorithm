package 코테연습.신규아이디추천_정규식;

/* 가입 유저들이 규칙에 맞지 않는 아이디 입력 시, 비슷한+규칙맞는 아이디 추천
규칙
- 아이디 길이 3자이상~15자이하
- 알파벳 소문자, 숫자, 빼기(-), (밑줄_), 마침표(.) 문자만 사용 가능
- 마침표(.)는 처음과 끝에 사용 불가능하고 연속 사용 불가능

*/
class Solution {
    public String solution(String new_id) {
        String answer = "";
        // 1번
        // new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        String first = new_id.toLowerCase();

        // 2번
        // new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        String second = first.replaceAll("[^a-z0-9-_.]","");

        // 3번
        // new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        String third = second.replaceAll("\\.{2,}",".");

        // 4번
        // new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        String fourth = third;
        if(fourth.charAt(0)=='.'){
            fourth = fourth.substring(1, fourth.length());
        }

        if(fourth.charAt(fourth.length()-1)=='.'){
            fourth = fourth.substring(0, fourth.length()-1);
        }

        // 5번
        // new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        String fifth = fourth;
        if(fifth.equals("")){
            fifth = "a";
        }

        // 6번
        // new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        String sixth = fifth;
        if(sixth.length() >=16){
            sixth = sixth.substring(0, 15);

            if(sixth.charAt(sixth.length()-1) == '.'){
                sixth = sixth.substring(0, sixth.length()-1);
            }
        }

        // 7번
        // new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        String seventh = sixth;
        while(seventh.length() <3){
            seventh += seventh.charAt(seventh.length()-1);
        }

        answer = seventh;
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("123_.def"));
    }
}
