package baekjoon.bfs_dfs;
import java.util.*;
import java.io.*;

public class Boj_14226 {
    static int s;
    static int[][] time = new int[1001][1001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());
        bfs();
        br.close();
    }

    static void bfs(){
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Arrays.asList(1,0))); // 왼쪽: screen, 오른쪽: clipboard
        time[1][0] = 0; // 0초. 시작점

        while (!queue.isEmpty()){
            List<Integer> temp = queue.poll(); // [1, 0]
            int screen = temp.get(0);
            int clipboard = temp.get(1);

            // 종료 조건
            if(screen == s) {
                System.out.println(time[screen][clipboard]);
                return;
            }

            // screen 에 있는 모든 이모티콘 복사, clipboard 에 저장
            if(0 < screen && screen < 1000){
                if(time[screen][screen] == 0){
                    time[screen][screen] = time[screen][clipboard] + 1;
                    queue.add(Arrays.asList(screen, screen));
                }
            }

            // clipboard 에 있는 모든 이모티콘을 화면에 붙여넣기
            if (screen + clipboard <= 1000){
                if (time[screen + clipboard][clipboard] == 0){
                    time[screen + clipboard][clipboard] = time[screen][clipboard] + 1;
                    queue.add(Arrays.asList(screen + clipboard, clipboard));
                }
            }

            // screen 에 있는 이모티콘 중 1개를 삭제
            if (screen - 1 > 0){
                if (time[screen - 1][clipboard] == 0){
                    time[screen - 1][clipboard] = time[screen][clipboard] + 1;
                    queue.add(Arrays.asList(screen - 1, clipboard));
                }
            }
        }

    }
}
