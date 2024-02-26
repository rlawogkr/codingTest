package baekjoon.graph;

/**
 * 무방향 그래프. 연결 요소의 개수를 구하는 프로그램.
 */
//BFS, 재귀 DFS, 비재귀 DFS

import java.io.*;
import java.util.*;

public class Boj_11724_bfs {
    static List<ArrayList<Integer>> adjacencyList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        visited = new boolean[vertex + 1];

        //인접리스트 생성
        for (int i = 0; i <= vertex; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        int cnt = 0;
        while (true) {
            if (cnt == edge) break;
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //무방향 그래프이기 때문에 양쪽에 값을 추가해줌.
            adjacencyList.get(x).add(y);
            adjacencyList.get(y).add(x);
            cnt++;
        }

        int count = 0;
        for(int i = 1; i<= vertex; i++){
            if(!visited[i]){
                bfs(i);
                count++;
            }
        }
        System.out.println(count);

        br.close();
    }

    static void bfs(int val) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(val);
        visited[val] = true;

        while (!q.isEmpty()) {
            int tmp = q.poll();
            int size = adjacencyList.get(tmp).size();
            for (int i = 0; i < size; i++) {
                int newVal = adjacencyList.get(tmp).get(i);
                if(!visited[newVal]){
                    q.offer(newVal);
                    visited[newVal] = true;
                }
            }
        }

    }
}
