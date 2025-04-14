package baekjoon.dijkstra;

import java.util.*;
import java.io.*;

public class Boj_1446 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 지름길의 개수
        int D = Integer.parseInt(st.nextToken()); // 고속도로의 길이
        int[][] road = new int[N][3];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            road[i][0] = Integer.parseInt(st.nextToken()); // 시작점
            road[i][1] = Integer.parseInt(st.nextToken()); // 끝점
            road[i][2] = Integer.parseInt(st.nextToken()); // 지름길 길이
        }
        // 시작점 기준으로 오름차순 정렬
        Arrays.sort(road, (o1, o2) -> {
            return Integer.compare(o1[0], o2[0]);
        });

        // 처음 이동거리 초기화
        int[] dp = new int[D+1]; // 해당 인덱스까지의 거리
        for(int i = 0; i <= D; i++){
            dp[i] = i;
        }

        for(int i = 0; i<= D; i++){
            if(i+1 <= D){ // 범위를 넘어가지 않을 떄 지름길과 원래 경로 거리 비교
                dp[i+1] = Math.min(dp[i+1], dp[i] + 1);
            }
            for(int j = 0; j < N ; j++){
                if(road[j][0] == i){ // 시작점이 i와 같을 때(지름길)
                    int end = road[j][1];
                    int len = road[j][2];

                    if(end <= D){ // 범위를 넘어가지 않을 경우
                        dp[end] = Math.min(dp[end], dp[i]+len);
                    }
                }
            }
        }
//        for(int i : dp) {
//            System.out.print(i + " ");
//        }
        System.out.println(dp[D]);

        br.close();
    }

}
