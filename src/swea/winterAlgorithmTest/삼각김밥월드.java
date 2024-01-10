package swea.winterAlgorithmTest;

import java.io.*;
import java.util.*;

public class 삼각김밥월드 {
    static int[][] map = new int[141][141];
    static boolean[][] visited = new boolean[141][141];
    static Queue<Integer> queue = new LinkedList<>();
    static int[] dx = {-1, -1, 0, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 0, -1};
    static int startX, startY, endX, endY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt((br.readLine()));
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());//시작지점
            int end = Integer.parseInt(st.nextToken());//끝지점

            //시작지점과 끝지점의 좌표를 구한다.
            startX = returnX(start);
            startY = start - startX * (startX + 1) / 2 - 1;
//            System.out.println("startX = " + startX + ", startY = " + startY);//지울것.
            //target 좌표
            endX = returnX(end);
            endY = end - endX * (endX + 1) / 2 - 1;
//            System.out.println("endX = " + endX + ", endY = " + endY);//지울것.
            bfs(startX, startY);
//            System.out.println("#" + tc + " " + map[endX][endY]);
            sb.append("#").append(tc).append(" ").append(map[endX][endY]).append("\n");
            //초기화
            map = new int[141][141];
            visited = new boolean[141][141];
        }
        System.out.println(sb);
        br.close();
    }

    static void bfs(int x, int y) {
        //1. 큐에 시작점을 넣고, 방문 표시를 한다.
        queue.offer(x);
        queue.offer(y);
        visited[x][y] = true;

        //2. 큐에 원소가 없을 때까지 반복한다.
        while (!queue.isEmpty()) {
            int a = queue.poll();
            int b = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = a + dx[i];
                int ny = b + dy[i];

                if (nx >= 0 && nx <= 140 && ny >= 0 && ny <= nx) {
                    if (!visited[nx][ny]) {
                        queue.offer(nx);
                        queue.offer(ny);
                        visited[nx][ny] = true;
                        map[nx][ny] = map[a][b] + 1;
                    }
                }
            }
        }

    }

    static int returnX(int target) {
        int x = 0;
        while (!(target <= (x + 1) * (x + 2) / 2)) {
            x++;
        }
        return x;
    }

}

