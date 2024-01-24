package baekjoon.dynamicProgramming;

import java.io.*;
import java.util.*;

public class 일이삼더하기_9095 {
    /*
    4를 만드려고 할 떄?
    D[i] = D[i-1] + D[i-2] + D[i-3]
    D[5] = D[4] + D[3] + D[2]
    D[4] = D[3] + D[2] + D[1]

    D[1] = 1,D[2] = 2,D[3] = 4


     */
    static int[] d = new int[11];//0부터 10까지 모든 개수 채우기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i < 11; i++) {
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(d[n]);
        }
        br.close();
    }

}
