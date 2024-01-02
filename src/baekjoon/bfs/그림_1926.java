package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그림_1926 {
    /*
    1.그림의 갯수, 그 그림 중 가장 넓은 그림의 넓이 출력
    2.대각선으로 연결된 부분은 연결된 것이 아님.
    dx는 행, dy는 열.
     */
    static int[][] drawing;
    static boolean[][] visited;
    static int n,m;

    static int[] dx = {0,0,-1,1};//상하좌우
    static int[] dy = {-1,1,0,0};//상하좌우
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer((br.readLine()));
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        drawing = new int[n][m];
        visited = new boolean[n][m];//방문 여부를 체크하는 배열

        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<m;j++){
                drawing[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxArea = 0;
        int count = 0;
        //함수를 호출할 때 중복으로 들어가는 것을 고려해서 짤 것.(거의 2시간 날림)
        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(drawing[i][j] == 1 && !visited[i][j]){
                    count++;//그림의 갯수
//                    System.out.println("i = " + i + ", j = " + j + ", bfs(i,j) = " + bfs(i,j));
                    maxArea = Math.max(maxArea,bfs(i,j));
//                    if(maxArea <= bfs(i,j)){
//                        maxArea = bfs(i,j);//가장 넓은 그림의 넓이
//                        System.out.println("i = " + i + ", j = " + j + ", maxArea = " + maxArea);
//                    }
                }
            }
        }
        System.out.println(count);
        System.out.println(maxArea);
        br.close();
    }

    static int bfs(int x, int y){
        int count = 0;
        //1.큐에 시작점을 넣고 방문처리
        queue.offer(x);
        queue.offer(y);
        visited[x][y] = true;

        //2.큐가 빌 때까지 반복(계속 Queue의 front를 pop, pop한 좌표의 상하좌우를 확인하며 Queue에 넣는다.)
        while(!queue.isEmpty()){
            int curX = queue.poll();
            int curY = queue.poll();
            count++;

            for(int i = 0;i<4;i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;//범위를 벗어나면 다음 방향으로
                if(drawing[nx][ny] == 0 || visited[nx][ny]) continue;//

                queue.offer(nx);
                queue.offer(ny);
                visited[nx][ny] = true;
            }
        }
        return count;
    }
}















