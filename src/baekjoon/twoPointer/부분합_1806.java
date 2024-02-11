package baekjoon.twoPointer;

import java.util.*;
import java.io.*;

public class 부분합_1806 {
    /**
     * 연속되는 수들의 부분합 중 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이?
     */
    private static int n, s;//n: 10,000 이하의 자연수, s: 100,000,000
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        s = Integer.parseInt(strings[1]);

        arr = new int[n];

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }


        int left = 0;
        int minLen = Integer.MAX_VALUE;//최소 길이.
        int sum = 0;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum >= s) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= arr[left];
                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(minLen);

        br.close();
    }

}
