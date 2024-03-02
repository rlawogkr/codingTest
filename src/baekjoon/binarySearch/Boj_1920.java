package baekjoon.binarySearch;

import java.util.*;
import java.io.*;

public class Boj_1920 {
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
            sb.append(binarySearch(i)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    //값이 있으면1, 없으면0
    static int binarySearch(int target) {
        int st = 0, en = arrA.length - 1;

        while (st <= en) {
            int mid = (st + en) / 2;
            if (target > arrA[mid]) st = mid + 1;
            else if (target < arrA[mid]) en = mid - 1;
            else return 1;
        }
        return 0;
    }
}
