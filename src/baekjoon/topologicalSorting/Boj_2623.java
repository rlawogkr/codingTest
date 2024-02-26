package baekjoon.topologicalSorting;

import java.util.*;
import java.io.*;

public class Boj_2623 {

    static List<ArrayList<Integer>> adj = new ArrayList<>();
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());//가수의 수
        int m = Integer.parseInt(st.nextToken());

        indegree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        //indegree, 인접리스트 초기화
        for (int i = 1; i <= m; i++) {
            String[] s = br.readLine().split(" ");

            int num = Integer.parseInt(s[0]);
            for (int j = 1; j < num; j++) {
                adj.get(Integer.parseInt(s[j])).add(Integer.parseInt(s[j + 1]));
                indegree[Integer.parseInt(s[j + 1])]++;
            }

        }

        topologicalSort(n);


        br.close();
    }

    // 위상 정렬
    public static void topologicalSort(int N) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);

            for (int next : adj.get(now)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        // result의 size()가 N이 아니라는 말은 그래프에서
        // 사이클이 발생하였다는 의미이다.
        // 사이클이 있으면, indegree가 0인 node를 큐에 넣지 못하면서
        // N개의 결과를 채우기도 전에 반복문이 종료되기 때문이다.
        if (result.size() != N) {
            System.out.println("0\n");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i) + "\n");
        }

        System.out.println(sb);

    }
}
