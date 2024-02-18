package baekjoon.dataStructure;

import java.util.*;
import java.io.*;

/**
 * 문자열 S. S의 서로 다른 부분 문자열의 개수?
 * 부분 문자열: 1보다 크거나 같아야 함. S에서 연속된 일부분을 의미.
 */
public class boj_11478 {
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        for(int i = 0;i<s.length();i++){
            for(int j = i+1;j<=s.length();j++){
                set.add(s.substring(i,j));
            }
        }
        System.out.println(set.size());
        br.close();
    }
}
