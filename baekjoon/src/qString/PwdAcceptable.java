package qString;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class PwdAcceptable {
    static String str;
    static char[] word;
    static int moCount;
//    static int jaCount;
    static boolean sameWord = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();

        while(true){
            str = br.readLine();
            if(Objects.equals(str, "end")){
                break;
            }
            word = new char[str.length()];
            moCount = 0;
//            jaCount = 0;
            sameWord = false;

            for(int i=0; i<str.length(); i++) {
                word[i] = str.charAt(i);

                if(moCheck(word[i])){
                    moCount++;
                }
            }

//            for(int j=0; j<word.length; j++){
//                char x = word[j];
//                if(moCheck(x)){
//                    moCount++;
//                    if(moCount == 3){
//                        break;
//                    }
//                } else if(j>=1){
//                    if(x == str.charAt(j - 1)){
//                        sameWord = true;
//                        break;
//                    }
//                } else {
//                    jaCount++;
//                    if(jaCount == 3){
//                        break;
//                    }
//                }
//            }

            for(int z=2; z< word.length; z++){ // 모음 혹은 자음이 3 연속 일 경우
                if(moCheck(word[z]) && moCheck(word[z-1]) && moCheck(word[z-2])){
                    sameWord = true;
                } else {
                    if(!moCheck(word[z]) && !moCheck(word[z-1]) && !moCheck(word[z-2])){
                        sameWord = true;
                    }
                }
            }

            for(int i = 1; i<word.length; i++){
                if(word[i] == word[i-1]){
                    if(word[i] != 'e' && word[i] != 'o'){
                        sameWord = true;
                    }
                }
            }
            if(moCount == 0 || sameWord){
                System.out.println("<"+str+"> "+"is not acceptable.");
            } else {
                System.out.println("<"+str+"> "+"is acceptable.");
            }
        }
    }
    static boolean moCheck(char c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
