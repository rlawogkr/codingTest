package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Topological_Sort {
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        //indegree 저장 배열. 노드가 1~8.
        int[] indegree = new int[9];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }
        //그래프의 각 edge 정보 초기화
        graph.get(1).add(2);
        graph.get(1).add(4);
        graph.get(2).add(5);
        graph.get(2).add(6);
        graph.get(3).add(6);
        graph.get(4).add(2);
        graph.get(4).add(8);
        graph.get(7).add(3);
        graph.get(8).add(6);
        for (ArrayList<Integer> integers : graph) {
            System.out.println(integers);
        }
        //각 indegree 배열 초기화
        for (int i = 1; i < graph.size(); i++) {
            if (graph.get(i).size() == 2) {
                indegree[graph.get(i).get(0)]++;
                indegree[graph.get(i).get(1)]++;
            } else if (graph.get(i).size() == 1) {
                indegree[graph.get(i).get(0)]++;
            }
        }
        //1~8까지의 노드이므로 1부터 시작. indegree값이 0인 값 큐에 때려박음. 시작값 setting.
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node + " ");
            List<Integer> list = graph.get(node);//해당 노드에서 뻗어나가는 정점 찾음.
            for (int i = 0; i < list.size(); i++) {
                indegree[list.get(i)]--;
                if(indegree[list.get(i)] == 0){
                    queue.offer(list.get(i));
                }
            }
        }
        System.out.println(sb);

    }
}
