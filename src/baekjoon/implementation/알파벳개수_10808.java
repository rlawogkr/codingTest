package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;

public class 알파벳개수_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        String s = br.readLine();
        solution(s);

        br.close();
    }
    static void solution(String s){
        int[] aplphabet = new int[26];
        for(int i = 0; i < s.length(); i++){
            aplphabet[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < aplphabet.length; i++){
            System.out.print(aplphabet[i] + " ");
        }

    }
}
