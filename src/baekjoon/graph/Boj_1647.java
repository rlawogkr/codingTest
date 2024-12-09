package baekjoon.graph;

import java.util.*;
import java.io.*;

// MST(모든 노드를 최소 비ㅣ용으로 연결하는 트리)
public class Boj_1647 {
    static class Node implements Comparable<Node> {
        int a;
        int b;
        int cost;

        Node(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost; // 비용의 오름차순 정렬
        }
    }
    static int[] parent;

    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x); // x의 부모를 찾는다.
        y = find(y); // y의 부모를 찾는다.
        if (x != y) parent[y] = x; // x와 y의 부모가 다르면 y의 부모를 x로 설정한다.
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드 개수
        int m = Integer.parseInt(st.nextToken()); // 길의 개수

        List<Node> arrayList = new ArrayList<>();
        // A와 B를 연결하는데 드는 비용이 C
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arrayList.add(
                    new Node(Integer.parseInt(st.nextToken())
                            , Integer.parseInt(st.nextToken())
                            , Integer.parseInt(st.nextToken())));
        }

        Collections.sort(arrayList); // 오름차순 정렬(비용)

        // 자기 자신을 부모로 설정
        parent = new int[n+1];
        for(int i = 1; i<=n; i++){
            parent[i] = i;
        }

        int mstCost = 0; // MST 비용
        int maxCost = 0; // 최대 비용

        for (Node node : arrayList) {
            if(find(node.a) != find(node.b)){
                union(node.a, node.b);
                mstCost += node.cost; // 간선 비용 저장
                maxCost = node.cost;
            }
        }
        System.out.println(mstCost - maxCost);
        br.close();
    }
}
