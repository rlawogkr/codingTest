package baekjoon.dynamicProgramming;

import java.util.*;
import java.io.*;

public class Boj_2293 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];
        int[] dp = new int[target+1];

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        //dp[i] = i원을 만들 수 있는 경우의 수
        //dp[i] = dp[i] + dp[i-coin]
        //1원짜리 동전으로 1원부터 10원까지 만들 수 있는 가지수 구함
        //2원짜리 동전으로 2원부터 10원까지 만들 수 있는 가지수 구함(1원으로 구한 값을 이용)
        //3원짜리 동전으로 3원부터 10원까지 만들 수 있는 가지수 구함(2원으로 구한 값을 이용)
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= target; j++) {
                dp[j] += dp[j - coin[i]];
            }
        }

        for (int i : dp) {
            System.out.print(i+" ");
        }
        System.out.println(dp[target]);
        br.close();
    }
}
