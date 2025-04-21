package baekjoon.graph;
import java.util.*;
import java.io.*;

public class Boj_1197 {
    static class Node implements Comparable<Node> {
        int from;
        int to;
        long cost;

        public Node(int from, int to, long cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(this.cost, other.cost);
        }
    }

    static int[] parent;

    // 부모 찾기 (경로 압축 사용)
    static int find(int from) {
        if (parent[from] == from) return from;
        return parent[from] = find(parent[from]);
    }

    // 두 집합 합치기 (Union 연산)
    static void union(int x, int y) {
        x = find(x); // x의 부모를 찾는다.
        y = find(y); // y의 부모를 찾는다.
        if (x != y) parent[y] = x; // x와 y의 부모가 다르면 y의 부모를 x로 설정한다.
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v, e;
        v = Integer.parseInt(st.nextToken()); // 정점 수
        e = Integer.parseInt(st.nextToken()); // 간선 수

        // 간선 정보를 저장하는 리스트
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            int from, to, cost;
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            nodes.add(new Node(from, to, cost));
        }

        // 간선 비용을 기준으로 오름차순 정렬
        Collections.sort(nodes);

        // Union-Find를 위한 부모 배열 초기화
        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        long totalCost = 0; // 최소 스패닝 트리의 비용
        int edgesUsed = 0;  // 사용된 간선의 개수

        // 간선을 하나씩 확인하며 MST 구성
        for (Node edge : nodes) {
            if (find(edge.from) != find(edge.to)) { // 사이클이 생성되지 않을 경우
                union(edge.from, edge.to); // 두 정점을 연결
                totalCost += edge.cost;   // 비용 추가
                edgesUsed++;

                if (edgesUsed == v - 1) break; // MST 완성
            }
        }

        // 결과 출력
        System.out.println(totalCost);
        br.close();
    }
}
