package baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2482 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        // 일직선 상에서 N개 중에 K개를 연속하지 않도록 뽑는 경우의 수
        int[][] baseDP = getDp(n);

        // 원형 모양의 i개의 색깔 중에서 j개를 선택할 수 있는 경우의 수
        if(k == 1) System.out.println(n);
        else System.out.println((baseDP[n-3][k-1] + baseDP[n-1][k]) % 1000000003);

        br.close();
    }

    public static int[][] getDp(int n){
        int[][] dp = new int[n+1][n+1]; // dp[i][j]: i개의 색깔 중에서 j개를 선택할 수 있는 경우의 수
        // 초기값 초기화
        dp[1][0] = 1;
        dp[1][1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(j == 1) dp[i][j] = i;
                else if(i > j) dp[i][j] = (dp[i-2][j-1] + dp[i-1][j]) % 1000000003;
            }
        }
        return dp;
    }
}