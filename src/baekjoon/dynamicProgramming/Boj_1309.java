package baekjoon.dynamicProgramming;

import java.io.*;
import java.util.*;
// 1309.동물원
public class Boj_1309 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n+1][3];//dp[n][m] : n: 우리의 크기, m: 마지막 줄에 배치된 동물의 상태
        //m:0: 동물이 없음, 1: 왼쪽에만 동물이 있음, 2: 오른쪽에만 동물이 있음
        dp[1][0] = 1; dp[1][1] = 1; dp[1][2] = 1;// 초기값 setting

        for(int i = 2; i<=n; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2])%9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1])%9901;
        }
        System.out.print((dp[n][0] + dp[n][1] + dp[n][2])%9901);

        br.close();
    }
}
