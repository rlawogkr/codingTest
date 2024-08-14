package baekjoon.backtracking;

import java.util.*;
import java.io.*;

public class Boj_1799 {
    static int[][] board;
    static boolean[][] visited;
    static int[][] copyBoard;
    static int n;
    static int cnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 값 초기화. 비숍을 놓을 수 있는 곳은 1, 없는 곳은 0
        board = new int[n][n];
        visited = new boolean[n][n];
        int availablePlace = 0;

        for (int i = 0; i<n ; i++){
            String[] s = br.readLine().split(" ");
            for (int j = 0; j<n ; j++){
                board[i][j] = Integer.parseInt(s[j]);
                if(board[i][j] == 1) availablePlace++;
            }
        }

        // copyBoard = board.clone(); // 깊은 복사가 되지 않음?
        // 깊은 복사
        copyBoard = new int[n][n];
        for (int i = 0; i<n; i++){
            copyBoard[i] = board[i].clone();
        }


        // 초기값(i,j) 를 돌면서 max 값보다 클 경우 값을 update
        int max = Integer.MIN_VALUE;
        for ( int x = 0; x<n; x++){
            for ( int y = 0; y<n; y++){
                if(board[x][y] == 1) {
                    cnt = 0;
                    backTracking(x, y);
                    max = Math.max(max, availablePlace - cnt + 1);

                    for (int k = 0; k<n; k++){
                        copyBoard[k] = board[k].clone();
                        Arrays.fill(visited[k], false);
                    }
                }
            }
        }

        System.out.println(max);
        br.close();
    }
    // 처음 좌표를 인자로 가짐. 지운 좌표의 개수를 return.
    // 지워야 하는 좌표 -> (y+1, x+1)
    static void backTracking(int x, int y){
        // 종료 조건
        if(x<0 || x>=n || y<0 || y>=n) return;

        copyBoard[x][y] = 0; // 들어가는 좌표는 전부 다 0으로 만듦.
        visited[x][y] = true;
        cnt++;


        // 우 상
        if((0 <= y+1 && y+1 < n) && (0 <= x+1 && x+1 < n) && !visited[y+1][x+1]) {
            copyBoard[x+1][y+1] = 0;
            cnt++;
            backTracking(x+1, y+1);
        }
        // 우 하
        if((0 <= y-1 && y-1 < n) && (0 <= x+1 && x+1 < n) && !visited[x+1][y-1]) {
            copyBoard[x+1][y-1] = 0;
            cnt++;
            backTracking(x+1, y-1);
        }
        // 좌 하
        if((0 <= y-1 && y-1 < n) && (0 <= x-1 && x-1 < n) && !visited[x-1][y-1]) {
            copyBoard[x-1][y-1] = 0;
            cnt++;
            backTracking(x-1, y-1);
        }
        // 좌 상
        if((0 <= y+1 && y+1 < n) && (0 <= x-1 && x-1 < n) && !visited[x-1][y+1]) {
            copyBoard[x-1][y+1] = 0;
            cnt++;
            backTracking(x-1, y+1);
        }
    }
}
