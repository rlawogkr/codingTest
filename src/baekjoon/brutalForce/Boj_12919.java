package baekjoon.brutalForce;

import java.io.*;
import java.util.*;
// 12919. A와 B 2
public class Boj_12919 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // s를 t로 바꿈.
        // 가능한 2가지 연산: A를 뒤에 추가, B를 뒤에 추가하고 뒤집기


        String s = br.readLine();
        String t = br.readLine();

        if(dfs(s, t)) System.out.println(1);
        else System.out.println(0);
        br.close();
    }

    public static boolean dfs(String s, String t) {
        if(s.equals(t)) return true;
        if(s.length() >= t.length()) return false;

        if(t.charAt(t.length()-1) == 'A') {
            return dfs(s, t.substring(0, t.length()-1));
        }
        else {
            return dfs(s, t.substring(0, t.length()-1));
        }
    }

}
