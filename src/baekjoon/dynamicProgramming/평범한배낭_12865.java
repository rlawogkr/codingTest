package baekjoon.dynamicProgramming;

import java.io.*;
import java.util.*;

/**
 * 여행에 필요하다고 생각하는 물건: N개.
 * 각 물건은 무게 W와 가치 V를 가짐. 해당 물건을 가지고 가면 V만큼 즐길 수 있음.
 * 최대 K만큼의 무게만을 넣을 수 있음. 배낭에 넣을 수 있는 물건들의 가치의 최댓값?
 */
public class 평범한배낭_12865 {
    static int n, k;
    static int[][] bags;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bags = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i][0] = Integer.parseInt(st.nextToken());//무게
            bags[i][1] = Integer.parseInt(st.nextToken());//가치
        }

        int[][] dp = new int[n + 1][k + 1]; // dp[i][j]: i번째 물건까지 고려하고, j무게까지 넣을 수 있을 때의 최대 가치.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (bags[i][0] <= j) { // i번째 물건을 넣을 수 있는 경우
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - bags[i][0]] + bags[i][1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][k]);
        br.close();
    }
}
