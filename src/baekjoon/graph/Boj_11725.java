package baekjoon.graph;
/**
 * 트리의 루트를 1. 각 노드의 부모를 구하는 프로그램.
 */

import java.util.*;
import java.io.*;

public class Boj_11725 {
    static int n;
    static int[] parent;
    static List<ArrayList<Integer>> adj = new ArrayList<>();//인접 리스트
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine()); // 노드의 개수
        parent = new int[n + 1]; // 부모 노드. 1의 부모는 0.
        parent[1] = 0;

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 1; i <= n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //트리는 무방향 그래프
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        bfs(1);

        for (int i : parent) {
            if(i == 0) continue;
            sb.append(i).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
    static void bfs(int val){
        queue.offer(val);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for (int next : adj.get(cur)) {
                if(parent[cur] == next)continue;
                queue.offer(next);
                parent[next] = cur;

            }
        }


    }
}
