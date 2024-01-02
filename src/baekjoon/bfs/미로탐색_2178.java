package baekjoon.bfs;

import java.io.*;
import java.util.*;

public class 미로탐색_2178 {
    static int n,m;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};//상하좌우
    static int[] dy = {-1,1,0,0};//상하좌우
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);//행
        m = Integer.parseInt(s[1]);//열

        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0;i<n;i++){
            s = br.readLine().split("");
            for(int j = 0;j<m;j++){
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }

        bfs(0,0);
        //출력 체크
        System.out.println("graph = ");
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(graph[n-1][m-1]);
        br.close();
    }

    static void bfs(int x, int y){
        //1. 큐에 시작점을 넣고, 방문 표시를 한다.
        queue.offer(x);
        queue.offer(y);
//        visited[x][y] = true;//여기서는 방문표시 필요없음(어차피 graph값이 1이면 방문한 것이기 때문에)
        //2. 큐에 원소가 없을 때까지 반복한다.
        while(!queue.isEmpty()){
            int a = queue.poll();
            int b = queue.poll();

            for(int i = 0;i<4;i++){
                int nx = a + dx[i];//상하좌우 이동
                int ny = b + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
//                    if(graph[nx][ny] == 1 && !visited[nx][ny]){//위와 같은 이유로 방문 표시 필요 없음.
                    if(graph[nx][ny] == 1){
                        queue.offer(nx);
                        queue.offer(ny);
                        graph[nx][ny] = graph[a][b] + 1; // 이동횟수
                    }
                }
            }
        }



    }
}
