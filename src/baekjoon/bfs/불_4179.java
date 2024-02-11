package baekjoon.bfs;

import java.util.*;
import java.io.*;
public class 불_4179 {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int row, col;
    static int[][] map;
    static boolean[][] visited;
    static int[][] jihoon;
    static int[][] fire;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        visited = new boolean[row][col];

        jihoon = new int[row][col];//bfs로 이동할 수 있는 거리 찍기.
        fire = new int[row][col];

        int jihoonX = 0, jihoonY = 0;

        //값 입력(확인 완료)
        for(int i = 0;i<row;i++){
            String s = br.readLine();
            for(int j = 0;j<col;j++){
                if(s.charAt(j) == '#'){
                    map[i][j] = 1;//벽
                }else if(s.charAt(j) == '.'){
                    map[i][j] = 0;//지나갈수있는 공간
                }else if(s.charAt(j) == 'J'){
                    map[i][j] = 2;//지훈
                    jihoonX = j;
                    jihoonY = i;
                }else{
                    map[i][j] = 3;//불
                    //불 나오는 위치 큐에 다 때려박기
                    visited[i][j] = true;
                    queue.offer(j);
                    queue.offer(i);
                    fire[i][j] = 1;

                }
            }
        }
        //불의 위치를 찾아서 bfs로 이동할 수 있는 거리 찍기. 모든 불의 위치 큐에 넣고 돌리기.
        setFire();
//
        visited = new boolean[row][col];//방문 여부 초기화.

        //지훈이의 위치를 찾아서 bfs로 이동할 수 있는 거리 찍기.
        setJihoon(jihoonX, jihoonY);

        int min = Integer.MAX_VALUE;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if((i == 0 || i == row - 1 || j == 0 || j == col - 1) && jihoon[i][j] != 0){
                    if(min > jihoon[i][j]){
                        min = jihoon[i][j];
                    }
                }
            }
        }
        if(min == Integer.MAX_VALUE)System.out.println("IMPOSSIBLE");
        else System.out.println(min);

        br.close();
    }
    static void setFire(){
        while(!queue.isEmpty()){
            int a = queue.poll();//불의 x좌표
            int b = queue.poll();//불의 y좌표

            for(int i = 0;i<4;i++){
                int newX = a + dx[i];
                int newY = b + dy[i];

                if(newX >= 0 && newY >= 0 && newX < col && newY < row){
                    if(map[newY][newX] != 1 && !visited[newY][newX]){
                        visited[newY][newX] = true;
                        queue.offer(newX);
                        queue.offer(newY);
                        fire[newY][newX] = fire[b][a] + 1;
                    }
                }
            }
        }
    }
    static void setJihoon(int x, int y){
        queue.offer(x);
        queue.offer(y);
        visited[y][x] = true;
        jihoon[y][x] = 1;

        while(!queue.isEmpty()){
            int a = queue.poll();//지훈이의 x좌표
            int b = queue.poll();//지훈이의 y좌표

            for(int i = 0;i<4;i++){
                int newX = a + dx[i];
                int newY = b + dy[i];

                if(newX >= 0 && newY >= 0 && newX < col && newY < row){
                    if(map[newY][newX] == 0 && !visited[newY][newX] && (fire[newY][newX] > jihoon[b][a] + 1 || fire[newY][newX] == 0)){
                        visited[newY][newX] = true;
                        queue.offer(newX);
                        queue.offer(newY);
                        jihoon[newY][newX] = jihoon[b][a] + 1;
                    }
                }

            }
        }
    }
}
