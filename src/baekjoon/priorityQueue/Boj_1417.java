package baekjoon.priorityQueue;

import java.util.*;
import java.io.*;

// 다솜이가 매수해야 하는 사람의 최솟값을 출력
public class Boj_1417 {
    static class Node{
        int idx;
        int val;

        Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o2.val,o1.val));
        int n = Integer.parseInt(br.readLine()); // 후보의 수
        int[] array = new int[n];

        // 후보들의 득표수 입력
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
            if (i != 0) { // 다솜(0번 후보)은 큐에 넣지 않음
                pq.offer(new Node(i, array[i]));
            }
        }

        int res = 0; // 매수해야 할 사람 수

        // 다솜이가 가장 많은 표를 얻을 때까지 반복
        while (!pq.isEmpty()) {
            Node top = pq.poll(); // 가장 많은 득표를 가진 후보
            if (array[0] > top.val) break; // 다솜이의 표가 가장 많으면 종료

            // 다솜의 표를 늘리고, 경쟁 후보의 표를 줄임
            array[0]++;
            array[top.idx]--;
            res++;

            // 우선순위 큐 갱신
            pq.offer(new Node(top.idx, array[top.idx]));
        }

        System.out.println(res);
        br.close();
    }
}
