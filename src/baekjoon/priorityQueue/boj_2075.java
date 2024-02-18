package baekjoon.priorityQueue;

import java.util.*;
import java.io.*;
public class boj_2075 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>(
                new Comparator<Long>() {
                    @Override
                    public int compare(Long o1, Long o2) {
                        return  (int)(o2 - o1);
                    }
                }
        );

        int n = Integer.parseInt(br.readLine());


        for(int i = 0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n;j++){
                pq.offer(Long.parseLong(st.nextToken()));
            }
        }

        int count = 0;
        while(count != n-1){
            pq.poll();
            count++;
        }
        System.out.println(pq.poll());

        br.close();
    }
}
