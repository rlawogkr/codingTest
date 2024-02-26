package baekjoon.topologicalSorting;

/**
 * n명의 학생들을 키 순서대로 줄 세우려고 한다.
 * 첫쨰 줄에 n, m 주어짐. m은 키를 비교한 횟수. 다음 m개의 줄에는 키를 비교한 두 학생의 번호 a,b가 주어짐.
 * a가 b보다 앞에 서야 한다는 의미.
 */

import java.io.*;
import java.util.*;

public class Boj_2252 {
    static int[] indegree;
    static List<ArrayList<Integer>> adj = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());//학생 수
        int m = Integer.parseInt(st.nextToken());//m은 비교 횟수.

        indegree = new int[n + 1];
        indegree[0] = -1;
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        //인접 리스트 값 초기화, indegree 초기화
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //방향이 있는 그래프
            adj.get(x).add(y);
            indegree[y]++;
        }

        topologicalSort(n);
        br.close();
    }

    static void topologicalSort(int n) {
        StringBuilder sb = new StringBuilder();
        //indegree 가 0인 것들 전부 큐에 넣음
        for (int i = 1; i <= n; i++) {
            if(indegree[i] == 0)q.offer(i);
        }

        while(!q.isEmpty()){
            int student = q.poll();
            sb.append(student).append(" ");

            //현재 학생과 연결된 학생의 indegree 감소
            for (int i : adj.get(student)) {
                indegree[i]--;
                if(indegree[i] == 0){
                    q.offer(i);
                }
            }
        }
        System.out.println(sb);
    }
}
