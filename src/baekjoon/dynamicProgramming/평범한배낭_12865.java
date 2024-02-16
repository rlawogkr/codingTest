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
        k = Integer.parseInt(st.nextToken());//최대 넣을 수 있는 무게

        //값 입력
        bags = new int[n][2]; // 각 물건의 무게(W)와 해당 물건의 가치(V)가 주어짐. 입력수는 모두 정수.
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i][0] = Integer.parseInt(st.nextToken());//w
            bags[i][1] = Integer.parseInt(st.nextToken());//v
        }



        int[] dp = new int[k + 1];//각 인덱스는 무게. value값은 실제 가치의 합.
        dp[k] = Integer.MIN_VALUE;
        //dp
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= bags[i][0]; j--) {
                dp[j] = Math.max(dp[j], dp[j - bags[i][0]] + bags[i][1]);
            }
        }
        System.out.println(dp[k]);
        br.close();
    }
}
