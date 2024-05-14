package baekjoon.implementation;

import java.io.*;
import java.util.*;

//1748. 수 이어 쓰기 1
public class Boj_1748 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int len = 1, cnt = 9, result = 0;//len: 자릿수, cnt: 자릿수별 최대값
        for(int i=1; i<=n; i++){
            if(i > cnt){
                len++;
                cnt += 9 * len * Math.pow(10, len-1);
            }
            result += len;
        }
        System.out.println(result);
        br.close();

    }
}
