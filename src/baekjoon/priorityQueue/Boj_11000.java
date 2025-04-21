package baekjoon.priorityQueue;

import java.util.*;
import java.io.*;

// si에서 시작, ti에서 종료. n개의 수업
// 최소의 강의실을 사용
public class Boj_11000 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] classes = new int[n][2];
        for (int i = 0; i<n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            classes[i][0] = Integer.parseInt(st.nextToken());
            classes[i][1] = Integer.parseInt(st.nextToken());
        }

        // 시작 기준으로 오름차순 정렬
        Arrays.sort(classes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // 종료시간 관리
        Queue<Integer> pq = new PriorityQueue<>();

        pq.offer(classes[0][1]); // 첫 번째 강의의 종료시간 추가

        for(int i = 1; i< n; i++){
            int st = classes[i][0];
            int en = classes[i][1];

            // i번째 강의의 시작시간이 가장 빨리 끝나는 강의보다 크거나 같으면 재사용
            if(st >= pq.peek()){
                pq.poll(); // 같을 경우 뽑음
            }

            pq.offer(en);
        }
        System.out.println(pq.size());
        br.close();
    }
}
