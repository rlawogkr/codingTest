package baekjoon.priorityQueue;

import java.util.*;
import java.io.*;

/**
 * 배열에 절댓값이 가장 작은 값을 출력, 그 값을 배열에서 제거.
 * 절댓값이 가장 작은 값이 여러 개일때는 가장 작은 수를 출력, 그 값을 배열에서 제거.
 * x가 0이 아니라면 배열에 추가. x가 0이라면 배열에서 절댓값 가장 작은 값 출력, 그 값을 제거.
 */
public class AbsoluteValueHeap_11286 {
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) != Math.abs(o2)) return Math.abs(o1) - Math.abs(o2);
                else return o1 - o2;
            }
        });

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp != 0){
                pq.offer(tmp);
            }else{
                if(!pq.isEmpty()) sb.append(pq.poll()).append("\n");
                else sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
