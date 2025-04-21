package baekjoon.twoPointer;

import java.util.*;
import java.io.*;

public class Boj_1522 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int totalA = 0; // 총 a의 개수

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == 'a')totalA++;
        }

        int currentA = 0; // 현재 윈도우의 a의 개수
        for(int i = 0; i<totalA ; i++){
            if(s.charAt(i) == 'a')currentA++;
        }

        int maxAInWindow = currentA;
        for(int st = 1; st < s.length(); st++){
            if(s.charAt(st-1) == 'a')currentA--; // 맨 앞이 a일 경우 -1
            int newIdx = (st + totalA - 1) % s.length();
            if(s.charAt(newIdx) == 'a')currentA++;
            maxAInWindow = Math.max(maxAInWindow, currentA);
        }
        System.out.println(totalA - maxAInWindow);
        br.close();
    }
}
