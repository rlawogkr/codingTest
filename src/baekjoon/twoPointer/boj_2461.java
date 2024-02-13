package baekjoon.twoPointer;

import java.io.*;
import java.util.*;

/**
 * 1반에서 1명의 대표선수를 선발.
 * 반에서 대표로 선발된 모든 학생들의 능력치 중, 최댓값과 최솟값의 차이가 최소가 되도록.
 */
public class boj_2461 {
    private static int n;//학급 수
    private static int m;//각 학급의 학생 수. 각 학급의 학생은 능력치를 가지고 있음.
    private static long[][] students;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        students = new long[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                students[i][j] = Long.parseLong(st.nextToken());
            }
            Arrays.sort(students[i]);
        }

        long sub = Long.MAX_VALUE;//return 값. 최소여야 함.
        //포인터가 가르키는 인덱스 나타냄
        int[] arr = new int[n];
        int minArray = 0;
        while(true) {
            long max = 0;
            long min = Long.MAX_VALUE;
            for(int i=0; i<n; i++) {
                //최대값 찾기
                if(students[i][arr[i]] > max) {
                    max = students[i][arr[i]];
                }
                //최소값 찾기
                if(students[i][arr[i]] < min) {
                    min = students[i][arr[i]];
                    minArray = i;
                }
            }
            //제일 작은 값 선택.
            sub = Math.min(sub, max-min);
            arr[minArray]++;
            if(arr[minArray] == m) break;
        }

        System.out.println(sub);


        br.close();
    }
}
