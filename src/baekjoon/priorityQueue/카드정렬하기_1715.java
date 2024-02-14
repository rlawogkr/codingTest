package baekjoon.priorityQueue;

import java.util.*;
import java.io.*;

/**
 * n개의 카드 묶음의 각각 크기가 주어질 때, 최소한 몇 번의 비교가 필요한지?
 * 다 합쳐질 때까지 매 순간마다 가장 작은 묶음 2개를 1개로 만들기.
 */
public class 카드정렬하기_1715 {
    static int n;
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        cards = new int[n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cards[i] = Integer.parseInt(st.nextToken());
            pq.offer(cards[i]);
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            if(pq.size() == 1){
                break;
            }
            int tmp1, tmp2;
            tmp1 = pq.poll();
            tmp2 = pq.poll();

            sum += (tmp1 + tmp2);
            pq.offer(tmp1 + tmp2);
        }
        System.out.println(sum);
        br.close();
    }
}
