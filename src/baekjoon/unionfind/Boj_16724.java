package baekjoon.unionfind;
import java.util.*;
import java.io.*;

public class Boj_16724 {
    static int find(int[] parent, int idx){
        return idx == parent[idx] ? idx : (parent[idx] = find(parent, parent[idx]));
    }
    static void union(int[] parent, int u, int v){
        int newU = find(parent, u);
        int newV = find(parent, v);
        if(newU != newV){
            parent[newV] = parent[newU];
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];  // map 초기화
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = s.charAt(j);
            }
        }

        // parent 초기화
        int[] parent = new int[N*M];
        for(int i = 0 ; i < parent.length; i++) parent[i] = i;

        for(int i = 0; i<N ; i++){
            for(int j = 0; j<M; j++){
                char c = map[i][j];
                int ni = i, nj = j;
                int dist = i * M + j;
                switch(c){
                    case 'U': ni -= 1; break;
                    case 'D': ni += 1; break;
                    case 'R': nj += 1; break;
                    case 'L': nj -= 1; break;
                }
                int newDist = ni * M + nj;
                union(parent, dist, newDist);
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i <N*M ; i++)set.add(find(parent, i));
        System.out.println(set.size());
        br.close();
    }
}
