package baekjoon.dynamicProgramming;

/**
 * LIS(최소 신장 부분수열): 수열에서 가장 큰 증가하는 부분수열 - 전체 크기(n)
 * 해당 index보다 작은 값 루프를 돌며 비교
 * 1. 자기보다 이전에 있는 값들 중에서 더 작은 값들을 모두 비교한다
 * 2. 더 작은 값들 중, 해당 값을 선택했을 때, 증가하는 부분수열의 크기가 기존의 값보다 더 커지는지 비교한다
 * 3. 2)의 결과로 기존의 값보다 더 커진다면, 그 값으로 갱신, 그게 아니라면 pass.
 */

import java.util.*;
import java.io.*;

public class Boj_2631 {
    static int[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];


        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            //해당 값보다 작은 값들 모두 비교.
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(n - max);


        br.close();
    }
}

// 3 7 5 2 6 1 4

// 1 2 2