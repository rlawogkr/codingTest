package baekjoon.topologicalSorting;

/**
 * 2번째 줄 1번 작업
 * 3번째 줄 2번 작업
 * ...
 * N+1번째 줄 N번 작업
 * 각 줄의 처음에는 해당 작업이 걸리는 시간, 다음 작업에 대해 선행관계가 있는 작업의 갯수, 선행관계 있는 작업 번호
 * 서로 선행관계가 없을 경우, 동시에 수행 가능.
 */

import java.io.*;
import java.util.*;

public class Boj_2056 {
    static int n;//수행해야할 작업
    static int[] time;//각 작업마다 걸리는 시간
    static int[] indegree;
    static List<ArrayList<Integer>> adj = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        time = new int[n + 1];//각 작업에 걸리는 시간
        indegree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());//i번째 작업에서 걸린 시간.

            int anotherJobs = Integer.parseInt(st.nextToken());
            for (int j = 0; j < anotherJobs; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                adj.get(i).add(tmp);
                indegree[tmp]++;
            }
        }
        topologicalSort(n);

        br.close();
    }

    static void topologicalSort(int n) {
        int[] sum = new int[n + 1]; // 각 작업을 하는데 걸린 총 시간.
        for (int i = 1; i <= n; i++) {
            sum[i] = time[i];
            if (indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : adj.get(cur)) {
                indegree[next]--;
                //각각의 작업마다 가장 긴 수행시간으로 설정해야 함.
                sum[next] = Math.max(sum[next], sum[cur] + time[next]);

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++){
            res = Math.max(res, sum[i]);
        }
        System.out.println(res);

    }
}
