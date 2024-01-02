package baekjoon.bfs;

import java.io.*;
import java.util.*;

public class 토마토_7576 {
    /*
    시작점이 여러 개인 bfs.

    창고에 있는 토마토가 며칠 뒤면 다 익게 되는지.
    상하좌우만 영향을 받음.
    정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸

    출력:
    토마토가 모두 익을 때까지의 최소 날짜를 출력한다.
    모든 토마토가 익어있음? 0 출력
    모든 토마토가 익지 못하는 상황? -1 출력
     */
    static int m,n;
    static int[][] tomatoes;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};//좌우상하
    static int[] dy = {-1,1,0,0};//좌우상하
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer((br.readLine()));
        m = Integer.parseInt(st.nextToken());//6
        n = Integer.parseInt(st.nextToken());//4

        tomatoes = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<m;j++){
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //모든 토마토가 익어있을 경우를 체크
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(tomatoes[i][j] != 0){
                    count++;
                }
            }
        }
        if(count == n*m){
            System.out.println(0);
            return;
        }

        //bfs
        //익어있는 토마토가 있는 시작점을 Queue에 먼저 넣고 bfs를 돌림.
        Queue<Integer> queue = new LinkedList<>();//시작점(item값이 1이면서, visited값이 false인 곳)을 먼저 큐에 넣기.
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(tomatoes[i][j] == 1 && !visited[i][j]){
                    queue.offer(i);
                    queue.offer(j);
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            int a = queue.poll();
            int b = queue.poll();
            for(int i = 0;i<4;i++){
                int nx = a + dx[i];
                int ny = b + dy[i];

                if(nx >= 0 && nx <n && ny >= 0 && ny <m ){
                    if(tomatoes[nx][ny] == 0 && !visited[nx][ny]){
                        queue.offer(nx);
                        queue.offer(ny);
                        visited[nx][ny] = true;
                        tomatoes[nx][ny] = tomatoes[a][b] + 1;
                    }
                }
            }
        }

        int max = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(tomatoes[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max,tomatoes[i][j]);
            }
        }
        System.out.println(max-1);
//        for(int i = 0;i<n;i++){
//            for(int j = 0;j<m;j++){
//                System.out.print(tomatoes[i][j] + " ");
//            }
//            System.out.println();
//        }

        br.close();
    }
    //값이 1일 경우 && 방문하지 않았을 경우 시작점으로 설정.
//    static void bfs(int x, int y){
//        //1. 큐에 시작점을 넣고, 방문 표시를 한다.
//        queue.offer(x);
//        queue.offer(y);
//        visited[x][y] = true;
//
//        //2. 큐에 원소가 없을 때까지 반복한다.
//        while(!queue.isEmpty()){
//            //3. 큐에서 원소를 하나 꺼낸다.
//            int a = queue.poll();
//            int b = queue.poll();
//
//            //4. 해당 원소와 인접한 원소들 중에서 조건에 맞는 원소를 큐에 넣고 방문처리를 한다.
//            for(int i = 0;i<4;i++){
//                int nx = a + dx[i];
//                int ny = b + dy[i];
//
//                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
//                    if(tomatoes[nx][ny] == 0 && !visited[nx][ny]){
//                        queue.offer(nx);
//                        queue.offer(ny);
//                        tomatoes[nx][ny] = tomatoes[a][b] + 1; // 이동횟수
//                        visited[nx][ny] = true;
//                    }
//                }
//            }
//        }
//
//    }
}
