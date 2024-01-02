package baekjoon.dataStructure;

import java.util.*;
import java.io.*;

public class 쇠막대기_10799 {

    /*
    () : 레이저
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '(') stack.push(s.charAt(i));
            else{
                stack.pop();
                if(s.charAt(i-1) == '(') answer += stack.size();//레이저. answer에 값을 더하는 이유는 레이저로 잘린 쇠막대기의 개수를 더하기 위함.
                else answer++;//answer에 값을 더하는 이유는 쇠막대기의 끝을 의미하기 때문.
            }
        }
        System.out.println(answer);
        br.close();
    }
}
