package baekjoon.bfs_dfs;

import java.util.*;
import java.io.*;

public class Boj_16928 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사다리의 수
        int M = Integer.parseInt(st.nextToken()); // 뱀의 수

        // jump 배열 생성
        int[] jumps = new int[101];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            jumps[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            jumps[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }


        // 실제 거리 생성
        int[] dist = new int[101];
        Arrays.fill(dist, -1);
        dist[1] = 0; // 시작점
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(cur == 100)break; // 종료 지점

            for(int d = 1; d <= 6; d++){
                int next = cur + d;
                if(next > 100) continue;                 // 범위를 벗어났을 경우
                if(jumps[next] != 0) next = jumps[next]; // 사다리나 뱀을 만났으면 그 위치로 이동
                if(dist[next] == -1){                    // 아직 방문하지 않았을 경우
                    dist[next] = dist[cur] + 1;
                    queue.offer(next);
                }
            }
        }
        System.out.println(dist[100]);
        br.close();
    }
}
