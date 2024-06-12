package baekjoon.dfs;
import java.util.*;
import java.io.*;
// 13023. ABCDE
public class Boj_13023 {
    static int n;
    static int m;
    static boolean[] visited;
    static StringBuilder sb;
    static List<Integer> adj_list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[m+1];
        adj_list = new ArrayList<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj_list.add(a);
            adj_list.add(b);
        }
        for(int i=0; i<m*2; i+=2){
            if(adj_list.get(i) == 0){
                dfs(adj_list.get(i+1), 1);
            }
        }
        br.close();
    }
    static void dfs(int start, int count){
        if(count == 4){
            System.out.println(1);
            System.exit(0);
        }
        visited[start] = true;
        for(int i=0; i<adj_list.size(); i++){
            if(adj_list.get(i) == start){
                int next = adj_list.get(i+1);
                if(!visited[next]){
                    dfs(next, count+1);
                }
            }
        }
        visited[start] = false;
    }
}









