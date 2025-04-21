package baekjoon.bfs_dfs;

import java.io.*;
import java.util.*;

public class Boj_2573 {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
        int getX(){
            return x;
        }
        int getY(){
            return y;
        }
    }

    // 만약 2개 이상으로 나뉘면 true, 아니면 false
    static boolean check(int[][] map){
        int r = map.length;
        int c = map[0].length;
        boolean[][] visited = new boolean[r][c];
        Node startNode = null;

        // 시작 지점 찾기
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != 0) {
                    startNode = new Node(i, j);
                    break;
                }
            }
            if (startNode != null) break;
        }

        // BFS로 연결된 빙산 방문 처리
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(startNode);
        visited[startNode.x][startNode.y] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int x = current.getX();
            int y = current.getY();

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c && !visited[nx][ny] && map[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny));
                }
            }
        }

        // 방문하지 않은 0이 아닌 지점이 남아있다면 분리된 빙산 존재
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    return true; // 2개 이상으로 분리됨
                }
            }
        }
        return false; // 분리되지 않음
    }
    // 빙산이 모두 녹아버린 경우 true 반환
    static boolean isAllMelted(int[][] map) {
        for (int[] row : map) {
            for (int cell : row) {
                if (cell != 0) return false; // 0이 아닌 부분이 있으면 false
            }
        }
        return true; // 모든 칸이 0인 경우
    }


    static void afterAYear(int[][] map) {
        int r = map.length;
        int c = map[0].length;
        int[][] newMap = new int[r][c];

        // 현재 상태를 복사
        for (int i = 0; i < r; i++) {
            newMap[i] = Arrays.copyOf(map[i], map[i].length);
        }

        // 각 빙산의 높이를 갱신
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != 0) { // 0이 아닌 위치에 대해서만 처리
                    int zeroCount = 0;

                    // 상하좌우 탐색
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx >= 0 && ny >= 0 && nx < r && ny < c && map[nx][ny] == 0) {
                            zeroCount++; // 주변에 0이 몇 개인지 카운트
                        }
                    }

                    // 빙산의 높이 감소
                    newMap[i][j] = Math.max(0, map[i][j] - zeroCount);
                }
            }
        }

        // 갱신된 상태를 원래 맵에 반영
        for (int i = 0; i < r; i++) {
//            System.arraycopy(newMap[i], 0, map[i], 0, c);
            map[i] = Arrays.copyOf(newMap[i], c);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int r = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);

        int[][] map = new int[r][c];

        // map 초기화
        for (int i = 0; i < r; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < tmp.length; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        int cnt = 0; // 빙산이 분리되는 데 걸리는 시간
        while (true) {
            if (check(map)) { // 빙산이 두 덩어리 이상으로 분리된 경우
                System.out.println(cnt);
                break;
            }

            afterAYear(map); // 1년 후의 상태 갱신
            cnt++;

            if (isAllMelted(map)) { // 모든 빙산이 녹아 분리될 수 없는 경우
                System.out.println(0);
                break;
            }
        }

        br.close();
    }
}
