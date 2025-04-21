package baekjoon.dijkstra;
import java.io.*;
import java.util.*;

public class Boj_1916 {
    static class Node implements Comparable<Node>{
        int to;
        int cost;

        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o){
            return Integer.compare(this.cost, o.cost);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수

        // 각 그래프 초기화
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i = 0; i < m; i++){
            int from, to, cost;
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost)); // 각 지점 초기화 [from] -> Node(to, cost), Node(to, cost) ...
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 실제 출발 도시
        int end = Integer.parseInt(st.nextToken()); // 실제 도착 도시

        // dijkstra 실행
        int[] dist = new int[n+1]; // 한 지점에서 다른 지점으로 가는 거리
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curCity = cur.to;
            int curCost = cur.cost;

            if(curCost > dist[curCity])continue; //만약 현재 지점에서 to 지점으로 가는 cost가 기존에 업데이트되었던 것보다 클 경우 패스

            for(Node next : graph.get(curCity)){
                int nextCity = next.to;
                int nextCost = curCost + next.cost;

                if(nextCost < dist[nextCity]){
                    dist[nextCity] = nextCost;
                    pq.add(new Node(nextCity, nextCost));
                }
            }
        }
        System.out.println(dist[end]);

        br.close();
    }
}
