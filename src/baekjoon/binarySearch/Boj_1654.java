package baekjoon.binarySearch;

import java.io.*;
import java.util.*;

// 1654. 랜선 자르기
public class Boj_1654 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수
        int n = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

        long[] arr = new long[k];
        long max = 0;
        for(int i = 0; i < k; i++){
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long left = 1;
        long right = max; // 가지고 있는 랜선 중 가장 긴 랜선의 길이
        long res = 0;

        while(left <= right){
            long mid = (left + right) / 2;
            long cnt = 0; // 랜선의 개수

            for(int i = 0; i < k; i++){
                cnt += arr[i] / mid;
            }

            if(cnt >= n){
                res = Math.max(res, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(res);
        br.close();
    }
}
