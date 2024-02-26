package baekjoon.bfs;

import java.io.*;
import java.util.*;

public class Boj_7562 {
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            int l = Integer.parseInt(br.readLine());// l * l 체스판
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] start = new int[2];
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] end = new int[2];
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            queue.add(start);
            int[][] visited = new int[l][l];
            visited[start[0]][start[1]] = 1;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                if (current[0] == end[0] && current[1] == end[1]) {
                    sb.append(visited[current[0]][current[1]] - 1).append("\n");
                    queue.clear();
                    break;
                }
                for (int j = 0; j < 8; j++) {
                    int nextX = current[0] + dx[j];
                    int nextY = current[1] + dy[j];
                    if (nextX >= 0 && nextX < l && nextY >= 0 && nextY < l && visited[nextX][nextY] == 0) {
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = visited[current[0]][current[1]] + 1;
                    }
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}
