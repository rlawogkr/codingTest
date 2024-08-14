package baekjoon.devideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Boj_2339 {

    static int[][] table;

    // x: 시작점 x좌표, y: 시작점 y좌표, a: 끝점 x좌표, b: 끝점 y좌표, horizontal: 현재 가로로 나누는지 여부
    public static int cutTable(int x, int y, int a, int b, boolean horizontal) {
        int divideComplete = 0, impurity = 0, jewel = 0;

        for (int i = x; i <= a; i++) {
            for (int j = y; j <= b; j++) {
                if (table[i][j] == 1) { // 영역에 불순물이 있는 경우
                    impurity++;
                    if (horizontal) { // 가로로 자르는 경우
                        divideComplete += cutTable(x, y, i - 1, b, !horizontal) * cutTable(i + 1, y, a, b, !horizontal);
                    } else { // 세로로 자르는 경우
                        divideComplete += cutTable(x, y, a, j - 1, !horizontal) * cutTable(x, j + 1, a, b, !horizontal);
                    }
                } else if (table[i][j] == 2) { // 영역에 보석이 있는 경우
                    jewel++;
                }
            }
        }

        if (impurity == 0) return (jewel == 1 ? 1 : 0);
        return divideComplete;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        table = new int[n][n];
        int impurity = 0, jewel = 0, answer;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());

                if (table[i][j] == 1) impurity++; // 불순물
                if (table[i][j] == 2) jewel++; // 보석
            }
        }

        if (impurity == 0) {
            answer = (jewel == 1 ? 1 : 0); // 불순물이 0이고, 보석이 1개인 경우 1, 아닌 경우 0
        } else {
            answer = cutTable(0, 0, n - 1, n - 1, true) +
                    cutTable(0, 0, n - 1, n - 1, false);
        }

        System.out.println(answer == 0 ? -1 : answer);
    }
}
