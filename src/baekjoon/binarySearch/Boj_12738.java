package baekjoon.binarySearch;

import java.io.*;
import java.util.*;
// 실패
public class Boj_12738 {
    static long[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new long[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if ((arr[i] > arr[j]) && (dp[i] < dp[j] + 1)) dp[i] = dp[j] + 1;
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
        br.close();
    }
}
