package baekjoon.backtracking;

import java.util.*;
import java.io.*;

public class NQueen_9663 {
    /*
    N*N 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제
     */
    static boolean[] isused1 = new boolean[14];// 세로 column 차지하고 있는지
    static boolean[] isused2 = new boolean[27];// / 대각선 차지하고 있는지
    static boolean[] isused3 = new boolean[27];// \ 대각선 차지하고 있는지
    static int count = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());//1~14
        backTracking(0);
        System.out.println(count);
        br.close();
    }

    static void backTracking(int depth){
        //종료 조건
        if(depth == N) {
            count++;
            return;
        }
        //세로로 값을 넣음(i), depth 는 가로.
        for(int i = 0;i<N;i++){
            if(isused1[i] || isused2[i+depth] || isused3[depth-i+N-1]) continue;//해당부분에 Queen 있을 경우 제외
            isused1[i] = true;
            isused2[i+depth] = true;
            isused3[depth-i+N-1] = true;
            backTracking(depth+1);
            isused1[i] = false;
            isused2[i+depth] = false;
            isused3[depth-i+N-1] = false;

        }

    }
}
