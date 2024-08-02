package baekjoon.bfs_dfs;

import java.io.*;
import java.util.*;
public class 숨바꼭질_1697 {
    /*
    수빈 위치: 점 N(0 ≤ N ≤ 100,000)
    동생 위치: 점 K(0 ≤ K ≤ 100,000)

    수빈: 걷기, 순간이동 가능
    걷기: X-1 or X+1
    순간이동: 2*X

    수빈이가 동생을 찾을 수 있는 가장 빠른 시간?
    걷기: X-1 or X+1 or 2*X 를 큐에 넣고 bfs를 돌린다.
     */
    static int n,k;
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited = new boolean[100001];
    static int[] distance = new int[100001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);//수빈 위치
        k = Integer.parseInt(s[1]);//동생 위치

        bfs(n);
        System.out.println(distance[k]);

        br.close();
    }

    static void bfs(int x){
        queue.offer(x);
        visited[x] = true;

        while(!queue.isEmpty()){
            int a = queue.poll();
            for(int i = 0;i<3;i++){
                int nx = move(i,a);

                if(nx >= 0 && nx <= 100000 && !visited[nx]){
                    queue.offer(nx);
                    visited[nx] = true;
                    distance[nx] = distance[a] + 1;
                }
            }
        }
    }
    //0이 들어오면 -1, 1이 들어오면 +1, 2가 들어오면 *2를 해서 반환한다.
    static int move(int i, int val){
        if(i == 0){
            return val - 1;
        } else if(i == 1){
            return val + 1;
        } else{
            return val * 2;
        }
    }


}
