package baekjoon.dynamicProgramming;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11054 {
    static long[] arr;
    static int[] dpA;
    static int[] dpB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new long[n];
        dpA = new int[n];
        dpB = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        //LIS
        for (int i = 0; i < n; i++) {
            dpA[i] = 1;
            for (int j = 0; j < i; j++) {
                if ((arr[i] > arr[j]) && (dpA[i] < dpA[j] + 1)) dpA[i] = dpA[j] + 1;
            }

        }
        //LDS. 거꾸로 오름차순 생각.
        for (int i = n - 1; i >= 0; i--) {
            dpB[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if ((arr[j] < arr[i]) && (dpB[j] + 1 > dpB[i])) dpB[i] = dpB[j] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dpA[i] + dpB[i] - 1); // 중복되는 부분 제거.
        }
        System.out.println(max);
        br.close();
    }
}
