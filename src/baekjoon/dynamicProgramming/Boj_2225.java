package baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2225. 합분해
public class Boj_2225 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[][] dp = new long[k+1][n+1];// dp[k][n]: 0부터 n까지의 정수 k개를 더해서 그 합이 n이 되는 경우의 수

        // 초기값 setting
        for(int i = 0;i<=n;i++){
            dp[1][i] = 1;
        }

        for(int i = 2;i<=k;i++){
            for(int j = 0;j<=n;j++){
                for(int l = j;l>=0;l--){
                    dp[i][j] += dp[i-1][j-l];//dp[i-1][0] + dp[i-1][1] + .. + dp[i-1][j]
                    dp[i][j] %= 1000000000;
                }
            }
        }
        System.out.println(dp[k][n]);

        br.close();
    }
}
