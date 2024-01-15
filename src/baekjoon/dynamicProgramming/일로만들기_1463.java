package baekjoon.dynamicProgramming;

import java.io.*;
import java.util.*;

/*
DP 접근방법(여러 하위 문제를 푼 후 그 결과를 쌓아올려 주어진 문제를 해겨하는 알고리즘.)
1. 테이블을 정의하기
2. 점화식을 찾기
3. 초기값 설정하기
DP 문제는 많은 문제를 풀어보는 것이 중요.
 */
public class 일로만들기_1463 {
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited = new boolean[1000000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        br.close();
    }
    static int cal(int val, int i){
        if(i == 0){
            return val/3;
        }else if( i == 1){
            return val/2;
        }else{
            return --val;
        }
    }
    /*
    X가 3으로 나누어 떨어지면, 3으로 나눈다.
    X가 2로 나누어 떨어지면, 2로 나눈다.
    1을 뺀다.
     */
    static int bfs(int x) {
        queue.offer(x);
        visited[x] = true;

        while(!queue.isEmpty()) {
            int a = queue.poll();
            for (int i = 0; i < 3; i++) {
                int nx = cal(a,i);

//                if(nx >=0 && )
            }
        }
        return 0;
    }
}
