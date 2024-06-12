package baekjoon.bfs;
import java.util.*;
import java.io.*;

public class Boj_14226 {
    static int[][] visited = new int[1001][1001];
    static int S; // S개의 이모티콘을 만드는 데 걸리는 시간
    static int bfs() {
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Arrays.asList(1, 0)));//화면, 클립보드
        visited[1][0] = 0;

        while (!queue.isEmpty()) {
            ArrayList<Integer> screen_clipboard = queue.poll();
            int screen = screen_clipboard.get(0);
            int clipboard = screen_clipboard.get(1);

            // screen 개수가 S개인 경우
            if(screen == S) return visited[screen][clipboard];

            // 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장
            if(0<screen && screen<=1000){
                if(visited[screen][screen] == 0){
                    visited[screen][screen] = visited[screen][clipboard] + 1;
                    queue.add(new ArrayList<>(Arrays.asList(screen, screen)));
                }
            }

            // 붙여넣기
            if(screen+clipboard<=1000){
                if(visited[screen+clipboard][clipboard] == 0){
                    visited[screen+clipboard][clipboard] = visited[screen][clipboard] + 1;
                    queue.add(new ArrayList<>(Arrays.asList(screen+clipboard, clipboard)));
                }
            }
            // 삭제
            if(screen-1>=0){
                if(visited[screen-1][clipboard] == 0){
                    visited[screen-1][clipboard] = visited[screen][clipboard] + 1;
                    queue.add(new ArrayList<>(Arrays.asList(screen-1, clipboard)));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        System.out.println(bfs());
        br.close();
    }
}
