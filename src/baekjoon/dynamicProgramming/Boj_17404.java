package baekjoon.dynamicProgramming;

import java.io.*;
// RGB거리 2
public class Boj_17404 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] RGB = new int[n][3];// RGB[i][j]: i번째 집을 j로 칠했을 때의 비용
        int[][] dp = new int[n][3];// dp[i][j]: i번째 집을 j로 칠했을 때의 최소값

        for(int i = 0;i<n;i++){
            String[] strings = br.readLine().split(" ");
            RGB[i][0] = Integer.parseInt(strings[0]);//Red
            RGB[i][1] = Integer.parseInt(strings[1]);//Green
            RGB[i][2] = Integer.parseInt(strings[2]);//Blue
        }

        int min = Integer.MAX_VALUE;
        //k: 첫번째 집을 칠하는 색깔 i: 0: Red, 1: Green, 2: Blue
        for(int k = 0;k<3;k++){
            for(int i = 0;i<3;i++){
                if(i==k) dp[0][i] = RGB[0][i]; // 초기값 setting
                else dp[0][i] = 1001;
            }
            for(int i = 1;i<n;i++){
                dp[i][0] = RGB[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
                dp[i][1] = RGB[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
                dp[i][2] = RGB[i][2] + Math.min(dp[i-1][0],dp[i-1][1]);
            }
            for(int i = 0;i<3;i++){
                if(i==k) continue;// 첫번째 집과 마지막 집의 색이 같으면 안됨
                min = Math.min(min,dp[n-1][i]);
            }
        }
        System.out.print(min);
        br.close();
    }
}
