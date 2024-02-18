package baekjoon.priorityQueue;

import java.util.*;
import java.io.*;
public class MaxHeap_11279 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                new Comparator<Integer>(){
                    @Override
                    public int compare(Integer o1, Integer o2){
                        return o2 - o1;
                    }
                }
        );
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 1<= n <= 100,000
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp != 0)pq.offer(tmp);
            else{
                if(pq.isEmpty())sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
