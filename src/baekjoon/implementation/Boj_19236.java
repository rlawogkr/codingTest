package baekjoon.implementation;

import java.io.*;
import java.util.*;

/**
 * 각 물고기는 번호(1<= x <=16)와 뱡향을 가짐. 두 물고기가 같은 번호를 갖는 경우는 없음.
 * 한 칸에는 물고기 한 마리.
 * 상어는 0,0 물고기를 먹고 시작.
 * 물고기는 번호가 작은 물고기부터 순서대로 이동.
 * 물고기는 한 칸을 이동할 수 있음.
 * 이동할 수 있는 칸? 빈 칸 || 물고기가 있는 칸 // 이동할 수 없는 칸: 상어 || 공간의 경계를 넘는 칸
 *
 * 각 물고기는 방향이 이동할 수 있는 칸을 향할 떄까지 45도 반시계 회전(이동할 수 있는 칸 없으면 이동 x)
 * 다른 물고기가 있는 칸으로 이동할 떄는 서로의 위치를 바꿈
 * 물고기의 이동이 모두 끝나면 상어가 이동
 * 상어는 방향이 있는 칸으로 이동할 수 있는데, 한 번에 여러 칸 이동 가능
 * 이동하는 중에 지나가는 칸에 있는 물고기는 먹지 않음(물고기가 없는 칸으로는 이동할 수 없음)
 */
public class Boj_19236 {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; // 상, 상좌, 좌, 좌하, 하, 하우, 우, 우상
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[][] map = new int[4][4];
    static Fish[] fishes = new Fish[17]; // 물고기 번호에 따른 위치 저장
    static int result = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i<4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<4; j++){
                int idx = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;

                fishes[idx] = new Fish(i, j, dir, idx, true); // 물고기 번호에 따른 위치 저장
                map[i][j] = idx;
            }
        }

        dfs(0, 0, 0, 0);
        System.out.println(result);

        br.close();
    }

    static void moveFish(int x, int y, Fish fish) {
        for (int i = 0; i < 8; i++) {
            int nx = fish.x + dx[fish.dir];
            int ny = fish.y + dy[fish.dir];

            // nx, ny가 경계를 넘거나 상어가 있는 경우
            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || (nx == x && ny == y)) {
                fish.dir = (fish.dir + 1) % 8;
                continue;
            }

            // 이동할 수 있는 경우
            Fish nextFish = fishes[map[nx][ny]];
            map[fish.x][fish.y] = nextFish.idx;
            map[nx][ny] = fish.idx;
            nextFish.x = fish.x;
            nextFish.y = fish.y;
            fish.x = nx;
            fish.y = ny;
            break;

        }
    }


    static void dfs(int x, int y, int dir, int sum) {
        sum += map[x][y];// 물고기 먹음
        dir = fishes[map[x][y]].dir;
        fishes[map[x][y]].isAlive = false;

        result = Math.max(result, sum);

        // 물고기 이동
        for (int i = 1; i <= 16; i++) {
            if (!fishes[i].isAlive) continue;
            moveFish(x, y, fishes[i]);
        }

        // 상어 이동
        for (int i = 1; i < 4; i++) {
            int nx = x + dx[dir] * i;
            int ny = y + dy[dir] * i;
            // 범위에 없거나, 물고기가 죽었을 경우
            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || !fishes[map[nx][ny]].isAlive) continue;

            // fishes, map 복제
            Fish[] copyFishes = new Fish[17];
            for (int j = 1; j <= 16; j++) {
                Fish fish = fishes[j];
                copyFishes[j] = new Fish(fish.x, fish.y, fish.dir, fish.idx, fish.isAlive);
            }

            int[][] copyMap = new int[4][4];
            for (int j = 0; j < 4; j++) {
                copyMap[j] = map[j].clone();
            }

            dfs(nx, ny, dir, sum);
            // 재귀 끝난 후 복구
            fishes = copyFishes;
            map = copyMap;
        }
    }
    static class Fish {
        int x, y, dir, idx;
        boolean isAlive;

        Fish(int x, int y, int dir, int idx, boolean isAlive) {
            {
                this.x = x;
                this.y = y;
                this.dir = dir; // 0~7
                this.idx = idx;
                this.isAlive = isAlive;
            }
        }
    }
}
