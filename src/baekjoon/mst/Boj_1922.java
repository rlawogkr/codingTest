package baekjoon.mst;

import java.io.*;
import java.util.*;

// 컴퓨터 연결하는 비용 최소로
public class Boj_1922 {
    static class Node implements Comparable<Node>{
        int from;
        int to;
        int cost;
        Node(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node node){
            return Integer.compare(this.cost, node.cost);
        }

    }
    static int[] parent;
    static int find(int x){
        if(parent[x] == x)return x;
//        return parent[x] = find(x); // 이걸 풀어서 쓰면 어떻게 되지?
//        int root = find(parent[x]);
//        parent[x] = root;
//        return root;
        return parent[x] = find(parent[x]);
    }
    static void union(int x, int y){
        int parentX = find(x); // 각 집합의 루트 노드를 찾음.
        int parentY = find(y);
        if(parentX != parentY){
            parent[parentX] = parent[parentY];
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int m = Integer.parseInt(br.readLine()); // 선의 수

        List<Node> nodeList = new ArrayList<>();

        for(int i = 0; i< m ; i++){
            st = new StringTokenizer(br.readLine());
            int a, b, c;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a == b) continue; // 같을 경우 pass
            nodeList.add(new Node(a,b,c));
        }
        Collections.sort(nodeList);

        // 부모 settings
        parent = new int[n+1];
        for(int i = 1; i<=n; i++){
            parent[i] = i;
        }

        int totalCost = 0;
        int usedComputer = 0;
        for (Node node : nodeList) {
            //System.out.println(node.from +" "+ node.to +" "+ node.cost);
            if(find(node.from) != find(node.to)) {
                union(node.from, node.to);
                totalCost += node.cost;
                usedComputer++;

                if(usedComputer == n-1)break;
            }
        }
        System.out.println(totalCost);

        br.close();
    }
}
