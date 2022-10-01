package 코테연습.JardenCase문자열만들기;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] wordList = s.split(" ");
        int strLength = s.length();
        int blanckCount = wordList.length-1; // 공백 개수
        int sumLength = blanckCount;
        StringBuffer sb = new StringBuffer();

        for(int i=0; i<wordList.length; i++){
            String word = wordList[i];
            int wordLength = word.length();
            String[] chWord = word.split("");

            sumLength = sumLength + wordLength;
            chWord[0] = chWord[0].toUpperCase();
            sb.append(chWord[0]);

            for(int j=1; j<chWord.length; j++){
                chWord[j] = chWord[j].toLowerCase();
                sb.append(chWord[j]);
            }
            if(i!=wordList.length-1) sb.append(" ");
        }

        if(strLength !=sumLength){
            sb.append(" ");
        }

        answer = sb.toString();
        return answer;
    }
}