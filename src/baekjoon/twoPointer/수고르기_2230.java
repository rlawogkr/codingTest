package baekjoon.twoPointer;

import java.io.*;
import java.util.*;

/**
 * 가장 작은 차이를 return.
 */
public class 수고르기_2230 {
    private static int n;
    private static int m;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());//n개의 정수로 이루어진 수열.
        m = Integer.parseInt(stringTokenizer.nextToken());//차이가 m 이상.
        arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        //1,2,3,4,5
        int st = 0;//st는 시작포인터, en는 끝포인터.

        int target = Integer.MAX_VALUE;
        for (int en = 0; en < arr.length ; en++) {
            if (arr[en] - arr[st] >= m) {
                target = Math.min(target, arr[en] - arr[st]);
                st++;
                en = st;
//                System.out.println("target: " + target + " st: " + st + " en: " + en);
            }
        }

        System.out.println(target);
        br.close();
    }
}
