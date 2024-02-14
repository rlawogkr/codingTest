package baekjoon.dynamicProgramming;

import java.io.*;
import java.util.*;

/**
 * 동전 종류: 1,5,10,50,100,500
 * 동전의 종류가 주어질 때, 주어진 금액을 만드는 모든 방법 return.
 */
public class Coin_9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {//test case
            int n = Integer.parseInt(br.readLine());//동전의 종류
            int[] coins = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }
            int target = Integer.parseInt(br.readLine());//만들어야 하는 금액
            int[] dp = new int[target + 1];//dp[target]: target 원을 만드는 방법의 수
            dp[0] = 1;
            for (int j = 0; j < n; j++) {
                for (int k = coins[j]; k <= target; k++) {
                    dp[k] += dp[k - coins[j]];
                }
            }
            sb.append(dp[target]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

}