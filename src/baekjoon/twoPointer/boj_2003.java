package baekjoon.twoPointer;

import java.io.*;
import java.util.*;

//i부터 j까지의 합이 m이 되는 경우의 수
public class boj_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());// target

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, sum = 0, count = 0;

        for (int right = 0; right < n; right++) {
            sum += arr[right];
            while(sum >= m){
                if (sum == m) count++;
                sum -= arr[left++];
            }
        }
        System.out.println(count);
        br.close();
    }
}
