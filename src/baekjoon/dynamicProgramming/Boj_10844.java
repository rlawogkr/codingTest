package baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 쉬운 계단 수
public class Boj_10844 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n+1][10];
        long mod = 1000000000;

        // dp[i][j] : 길이가 i이고 마지막 숫자가 j인 계단 수의 개수
        // 초기값 setting
        for(int i = 1; i<10; i++){
            dp[1][i] = 1;
        }
        for(int i = 2; i<=n; i++){
            for(int j = 0; j<10; j++){ // 0~9
                if(j==0) dp[i][j] = dp[i-1][1]%mod; // 0일 때는 1만 올 수 있음
                else if(j==9) dp[i][j] = dp[i-1][8]%mod;// 9일 때는 8만 올 수 있음
                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%mod;
            }
        }
        long sum = 0;
        for(int i = 0; i<10; i++){
            sum += dp[n][i];
        }
        System.out.print(sum%mod);

        br.close();
    }
}
