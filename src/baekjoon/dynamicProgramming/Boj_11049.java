package baekjoon.dynamicProgramming;

import java.io.*;
import java.util.*;
public class Boj_11049 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][2];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n][n];//dp[i][j]: i번째 행렬부터 j번째 행렬까지 곱하는데 필요한 최소 곱셈 연산 횟수

        for(int i=0; i<n-1; i++){
            dp[i][i+1] = matrix[i][0] * matrix[i][1] * matrix[i+1][1];
        }
        for(int i=2; i<n; i++){
            for(int j=0; j<n-i; j++){
                int k = i+j;
                dp[j][k] = Integer.MAX_VALUE;
                for(int l=j; l<k; l++){
                    //
                    dp[j][k] = Math.min(dp[j][k], dp[j][l] + dp[l+1][k] + matrix[j][0] * matrix[l][1] * matrix[k][1]);
                }
            }
        }
        System.out.println(dp[0][n-1]);
    }
}
