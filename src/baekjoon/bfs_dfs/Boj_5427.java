package baekjoon.bfs_dfs;
import java.util.*;
import java.io.*;

public class Boj_5427 {
    static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dy = {0, 1, 0, -1};
    static char[][] building;
    static int[][] fireTime; // 불이 해당 칸에 도달한 시간
    static int[][] sanggeunTime; // 상근이가 해당 칸에 도달한 시간
    static Queue<int[]> fireQueue = new LinkedList<>(); // 불의 위치를 담을 큐
    static Queue<int[]> sanggeunQueue = new LinkedList<>(); // 상근이의 위치를 담을 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Arrays.sort(new String[]{});
        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            building = new char[r][c];
            // 불이 퍼지는 시간, 상근이가 이동하는 시간
            fireTime = new int[r][c];
            sanggeunTime = new int[r][c];

            for (int i = 0; i < r; i++) {
                Arrays.fill(fireTime[i], -1);
                Arrays.fill(sanggeunTime[i], -1);
            }

            for (int i = 0; i < r; i++) {
                String line = br.readLine();
                for (int j = 0; j < c; j++) {
                    building[i][j] = line.charAt(j);
                    if (building[i][j] == '*') {
                        fireQueue.add(new int[]{i, j});
                        fireTime[i][j] = 0; // 불의 시작 시간은 0초
                    }
                    if (building[i][j] == '@') {
                        sanggeunQueue.add(new int[]{i, j});
                        sanggeunTime[i][j] = 0; // 상근이의 시작 시간은 0초
                    }
                }
            }

            // 1. 불이 퍼지는 시간을 먼저 계산
            moveFire();

            // 2. 상근이가 이동하는 경로 계산
            int result = moveSanggeun();

            // 3. 결과 출력
            if (result == -1) {
                sb.append("IMPOSSIBLE").append("\n");
            } else {
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void moveFire() {
        while (!fireQueue.isEmpty()) {
            int[] current = fireQueue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= building.length || ny < 0 || ny >= building[0].length) continue;
                if (building[nx][ny] == '#' || fireTime[nx][ny] != -1) continue; // 벽이거나 이미 방문한 칸

                fireTime[nx][ny] = fireTime[x][y] + 1;
                fireQueue.add(new int[]{nx, ny});
            }
        }
    }

    static int moveSanggeun() {
        while (!sanggeunQueue.isEmpty()) {
            int[] current = sanggeunQueue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 빌딩 경계에 도달한 경우 탈출 성공
                if (nx < 0 || nx >= building.length || ny < 0 || ny >= building[0].length) {
                    return sanggeunTime[x][y] + 1;
                }

                // 벽이거나 불이 붙은 칸, 또는 이미 방문한 칸이면 continue
                if (building[nx][ny] == '#' || sanggeunTime[nx][ny] != -1) continue;
                if (fireTime[nx][ny] != -1 && fireTime[nx][ny] <= sanggeunTime[x][y] + 1) continue;

                sanggeunTime[nx][ny] = sanggeunTime[x][y] + 1;
                sanggeunQueue.add(new int[]{nx, ny});
            }
        }
        return -1; // 탈출 불가능한 경우
    }
}
