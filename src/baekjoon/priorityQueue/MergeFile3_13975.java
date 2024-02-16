package baekjoon.priorityQueue;

import java.io.*;
import java.util.*;

/**
 * 소설의 모든 장을 쓰고나서, 각 장이 쓰여진 파일을 합쳐 한 개의 파일을 만듦.
 * 두 개의 파일을 합칠 때 필요한 비용: 두 파일 크기의 합.
 * return: 최종적인 1개의 파일을 완성하는데 필요한 비용의 총 합.
 */
public class MergeFile3_13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();

            for (int j = 0; j < n; j++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
            //이 코드가 더 깔끔하고 이뻐보임.
            long res = 0;
            while (pq.size() > 1) {
                long tmp1 = pq.poll();
                long tmp2 = pq.poll();
                res += (tmp1 + tmp2);
                pq.offer(tmp1 + tmp2);
            }
            sb.append(res).append("\n");
//            for (int j = 0; j < n; j++) {
//                if(j == n-1) {
//                    sb.append(res).append("\n");
//                    pq.clear();
//                    res = 0;
//                }
//                else{
//                    long tmp1 = pq.poll();
//                    long tmp2 = pq.poll();
//                    res += (tmp1+tmp2);
//                    pq.offer(tmp1+tmp2);
//                }
//            }
        }
        System.out.println(sb);
        br.close();
    }
}
