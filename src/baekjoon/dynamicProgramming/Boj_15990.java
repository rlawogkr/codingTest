package baekjoon.dynamicProgramming;

import java.io.*;
import java.util.*;
// 1,2,3 더하기 5
public class Boj_15990 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        //정수 n이 주어졌을 때, n을 1,2,3의 합으로 나타내는 방법의 수를 구하는 프로그램
        //각 테스트 케이스에 대해 정수 n을 1,2,3의 합으로 나타내는 방법의 수를 1,000,000,009로 나눈 나머지를 출력
        long[][] dp = new long[100001][4];//dp[n][m] : n: 만드려는 수, m: 마지막으로 더한 수
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;

        for(int i = 4; i<=100000; i++){
            dp[i][1] = (dp[i-1][2] + dp[i-1][3])%1000000009;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3])%1000000009;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2])%1000000009;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append((dp[n][1] + dp[n][2] + dp[n][3])%1000000009).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
