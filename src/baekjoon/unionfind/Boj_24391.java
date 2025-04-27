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

        int[] classRoom = new int[N+1];
        int cid = 0;
        for(int i = 1; i <= N; i++){
            if(classRoom[i] == 0){
                cid++;
                Queue<Integer> queue = new ArrayDeque<>();

                classRoom[i] = cid;
                queue.add(i);
                while(!queue.isEmpty()){
                    int u = queue.poll();
                    for(int v : adjList[u]){
                        if(classRoom[v] == 0){
                            classRoom[v] = cid; // 부모와 같은 번호를 부여
                            queue.add(v);
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
            if(classRoom[arr[i]] != classRoom[arr[i+1]])cnt++;
        }
        System.out.println(cnt);
        br.close();
    }
}
