package baekjoon.binarySearch;

import java.util.*;
import java.io.*;

public class Boj_10816 {
    static int n, m;
    static int[] arrA, arrB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arrA = new int[n];
        Map<Integer, Integer> counter = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
            if(counter.containsKey(arrA[i]))counter.put(arrA[i],counter.get(arrA[i])+1);
            else counter.put(arrA[i], 1);
        }

        Arrays.sort(arrA);

        m = Integer.parseInt(br.readLine());
        arrB = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : arrB) {
            int idx = Arrays.binarySearch(arrA, i);

            if(idx >= 0) sb.append(counter.get(arrA[idx])).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

}
