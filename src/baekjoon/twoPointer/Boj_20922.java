package baekjoon.twoPointer;

import java.util.*;
import java.io.*;

public class Boj_20922 {
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());//같은 원소가 k개 이하로 들어있음.

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, max = Integer.MIN_VALUE;
        int[] bitmask = new int[200001];//해당 value 값이 올 때, 해당 index 증가

        for (int right = 0; right < n; right++) {
            int value = arr[right];
            bitmask[value]++;

            while (bitmask[value] > k) {
                bitmask[arr[left]]--;
                left++;
            }

            max = Math.max(max, right - left + 1);

        }
        System.out.println(max);

        br.close();
    }
}
