package baekjoon.sort;

import java.io.*;
import java.util.*;

public class 수정렬하기5_15688 {
    static int N;//1<= N <= 1,000,000
    static int max = 1000002;
    static int[] postiveCount = new int[max];//양수 저장
    static int[] negativeCount = new int[max];//음수 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            if(val >= 0)postiveCount[val]++;
            else negativeCount[Math.abs(val)]++;//순서는 반대로 생각.
        }
        for (int i = max-1; i > 0; i--) {
            while(negativeCount[i]>0){
                sb.append(-i).append("\n");
                negativeCount[i]--;
            }
        }

        for (int i = 0; i < max; i++) {
            while(postiveCount[i]>0){
                sb.append(i).append("\n");
                postiveCount[i]--;
            }
        }
        System.out.println(sb);

        br.close();
    }
}
