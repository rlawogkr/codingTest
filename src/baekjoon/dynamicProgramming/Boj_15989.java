package baekjoon.dynamicProgramming;

/**
 * 정수 n이 주어졌을 때, n을 1,2,3의 합으로 나타내는 방법의 수?
 */

import java.io.*;

public class Boj_15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            int target = Integer.parseInt(br.readLine());
            sb.append(solution(target)).append("\n");
        }
        System.out.println(sb);

        br.close();
    }

    static int solution(int target) {
        if(target < 4){
            return target;
        }

        int[][] dp = new int[target + 1][4]; // dp 배열 초기화

        // 초기값 설정
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;


        for (int i = 4; i <= target; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }

        return dp[target][1] + dp[target][2] + dp[target][3];
    }
}
