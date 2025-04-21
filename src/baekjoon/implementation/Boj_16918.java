package baekjoon.implementation;

import java.util.*;
import java.io.*;

/**
 * 1. 일부 칸에 폭탄을 설치.
 * 2. 다음 1초동안 아무것도 하지 않음.
 * 3. 다음 1초동안 폭탄이 설치되어 있지 않은 모든 칸에 폭탄 설치.
 * 4. 1초가 지난 후 3초 전에 설치된 폭탄 모두 폭발
 *
 * 총 R개의 줄에 N초가 지난 후에 격자판의 상태를 출력.
 */
public class Boj_16918 {

    public static void bomb(int r, int c, int time, Character[][] map, int[][] timers) {
        // 짝수일 때는 설치만
        if (time % 2 == 0) {
            // 모든 칸에 폭탄 설치
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] == '.') {
                        map[i][j] = 'O';
                        timers[i][j] = time + 3; // 3초 후 폭발
                    }
                }
            }
        } else {
            // 3초 전에 설치된 폭탄 폭발
            Character[][] newMap = new Character[r][c];
            for (int i = 0; i < r; i++) {
                Arrays.fill(newMap[i] = new Character[c], 'O'); // 배열 초기화와 함께 모든 칸에 폭탄을 설치된 상태로 설정
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] == 'O' && timers[i][j] == time) {
                        // 현재 위치 폭발
                        newMap[i][j] = '.';
                        // 인접한 칸 폭발
                        if (i > 0) newMap[i - 1][j] = '.';
                        if (i < r - 1) newMap[i + 1][j] = '.';
                        if (j > 0) newMap[i][j - 1] = '.';
                        if (j < c - 1) newMap[i][j + 1] = '.';
                    }
                }
            }

            // 배열 복사 (Arrays.copyOf를 사용하여 각 행 복사)
            for (int i = 0; i < r; i++) {
                map[i] = Arrays.copyOf(newMap[i], c);
            }
//            for (int i = 0; i < r; i++) {
//                System.arraycopy(newMap[i], 0, map[i], 0, c);
//            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int r = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);
        int n = Integer.parseInt(s[2]);

        Character[][] map = new Character[r][c];
        int[][] timers = new int[r][c]; // 각 칸의 폭발 시간을 기록

        // 초기값 세팅
        for (int i = 0; i < r; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < c; j++) {  // 여기서 열의 개수만큼 반복하도록 수정
                map[i][j] = tmp.charAt(j);
                timers[i][j] = map[i][j] == 'O' ? 3 : 0; // 폭탄 초기 설치 시 3초 후 폭발
            }
        }

        // 1초일 경우 초기 상태 출력
        if (n == 1) {
            printMap(map);
        } else {
            // 시간 진행
            for (int time = 2; time <= n; time++) {
                bomb(r, c, time, map, timers);
            }
            // 결과 출력
            printMap(map);
        }

        br.close();
    }

    public static void printMap(Character[][] map) {
        StringBuilder sb = new StringBuilder();
        for (Character[] row : map) {
            for (Character cell : row) {
                sb.append(cell);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
