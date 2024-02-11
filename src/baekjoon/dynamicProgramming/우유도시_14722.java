package baekjoon.dynamicProgramming;

import java.util.*;
import java.io.*;

/**
 * 우유마시는 규칙:
 * 1st: 딸기우유(0) -> 초코(1) -> 바나나(2) -> 딸기(0) -> ,,,
 * (1,1)에서 출발 -> (N,N)으로 가면서 우유를 사 마심.
 * 각각의 우유 가게는 딸기, 초코, 바나나 중 1종류 우유만 취급.
 * 동쪽과 남쪽으로만 움직임. 마실 수 있는 우유의 최대 개수?
 */
public class 우유도시_14722 {
    private static int[][] milks;
    private static int[][][] count;//이전에 어떤 값이 채택되었는지를 저장.
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        milks = new int[N+1][N+1];
        count = new int[N+1][N+1][3];//DP.


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                milks[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                /**
                 * 0 -> 1
                 * 1 -> 2
                 * 2 -> 0
                 */
                int currentMilk = milks[i][j];

                if(currentMilk == 0){
                    count[i][j][0] = Math.max(count[i][j-1][2]+1, count[i-1][j][2]+1);
                } else{
                    count[i][j][0] = Math.max(count[i][j-1][0], count[i-1][j][0]);
                }

                if(currentMilk == 1 && count[i][j][0] > count[i][j][1]){
                    count[i][j][1] = Math.max(count[i][j-1][0]+1, count[i-1][j][0]+1);
                } else{
                    count[i][j][1] = Math.max(count[i][j-1][1], count[i-1][j][1]);
                }

                if(currentMilk == 2 && count[i][j][1] > count[i][j][2]){
                    count[i][j][2] = Math.max(count[i][j-1][1]+1, count[i-1][j][1]+1);
                } else{
                    count[i][j][2] = Math.max(count[i][j-1][2], count[i-1][j][2]);
                }

            }
        }


        System.out.println(Math.max(count[N][N][0], Math.max(count[N][N][1],count[N][N][2])));


        br.close();
    }


}
