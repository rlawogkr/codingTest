package baekjoon.binarySearch;

import java.io.*;
import java.util.*;

/**
 * int idx = Arrays.binarySearch(T[] a, T key)
 * 배열 a에 key 가 있을 경우, 해당 key 의 인덱스를 반환하고,
 * 배열 a에 key 가 없을 경우, 음수값을 반환한다. -(삽입지점) - 1
 */
public class Boj_1920_2 {
    static int n, m;
    static int[] arrA, arrB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arrA = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);

        m = Integer.parseInt(br.readLine());
        arrB = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for (int i : arrB) {
            if(Arrays.binarySearch(arrA, i) >= 0)sb.append(1).append("\n");
            else sb.append(0).append("\n");

        }
        System.out.println(sb);
        br.close();
    }


}
