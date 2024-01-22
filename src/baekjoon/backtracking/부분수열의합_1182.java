package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class 부분수열의합_1182 {
    /*
    N개의 정수.
    크기가 양수인 부분수열 중 해당 수열 원소의 합이 S
     */
    static int[] arr;
    static boolean[] visited;
    static int n,s,count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());//1<= n <= 20(정수의 개수)
        s = Integer.parseInt(st.nextToken());//-1,000,000 <= s <= 1,000,000(목표 합)
        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        System.out.println(count);
        br.close();
    }
    //목표값은 s, 개수는 n
    static void dfs(int depth, int target){
        if(target == s)count++;
        if(depth == n) return;//종료 조건

        for(int i = 0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1,target+arr[i]);
                visited[i] = false;
            }
        }
    }
}
