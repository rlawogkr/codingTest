package baekjoon.unionfind;

import java.io.*;
import java.util.*;

public class Boj_24391 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 강의의 개수
        int M = Integer.parseInt(st.nextToken()); // 건물의 쌍의 개수

        List<Integer>[] adjList = new ArrayList[N+1];
        for(int i = 1 ; i <= N; i++)adjList[i] = new ArrayList<>(); // 초기화

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v);
            adjList[v].add(u);
        }

        int[] classCode = new int[N+1];
        int cid = 0;

        for(int i = 1; i <= N; i++){
            if(classCode[i] == 0){
                cid++;
                classCode[i] = cid;

                Queue<Integer> q = new ArrayDeque<>();
                q.offer(i);
                while(!q.isEmpty()){
                    int u = q.poll();
                    for(int v : adjList[u]){
                        if(classCode[v] == 0){
                            classCode[v] = cid;
                            q.offer(v);
                        }
                    }
                }
            }
        }

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)arr[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for(int i = 0; i < arr.length-1; i++){
            if(classCode[arr[i]] != classCode[arr[i+1]])cnt++;
        }
        System.out.println(cnt);
        br.close();
    }
}
