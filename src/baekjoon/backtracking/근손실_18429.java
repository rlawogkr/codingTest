package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class 근손실_18429 {
    /*
    하루가 지날 때마다 K만큼의 중량이 감소.
    하루에 1개씩 kit를 사용. 사용 시마다 중량이 증가.(kit의 순서는 random)
    N일동안 1번씩만 사용 가능.

    운동 기간(1일차~N일차) 동안 항상 중량이 500 이상이 되도록 해야함.
    해당 조건을 만족하는 모든 경우의 수를 return.

     */
    static int N, K;
    static boolean[] visited;
    static int[] kit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());//(1 ≤ N ≤ 8, 1 ≤ K ≤ 50)
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        kit = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            kit[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 500);
        System.out.println(count);
        br.close();
    }
    static int count = 0;

    static void dfs(int cnt, int weight) {
        //1. 종료조건
        if(weight < 500){
            return;
        }
        if(cnt == N){
            count++;
            return;
        }
        //2. 재귀호출
        for(int i = 0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(cnt+1, weight+kit[i]-K);
                visited[i] = false;
            }
        }
    }

}
















