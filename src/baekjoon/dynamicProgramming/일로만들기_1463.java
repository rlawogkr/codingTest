package baekjoon.dynamicProgramming;

import java.io.*;
import java.util.*;

public class 일로만들기_1463 {
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited = new boolean[1000001];//1보다 크거나 같고, 10^6보다 작거나 같은 정수
    static int[] numbers = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());//1보다 크거나 같고, 10^6보다 작거나 같은 정수
        numbers[x] = 1;// 해당 지점이 시작점
        bfs(x);
        System.out.println(numbers[1]-1);
        br.close();
    }
    static int cal(int val, int i){
        if(i == 0 && val%3 == 0){ //3으로 나누어 떨어질 경우
            return val/3;
        }else if( i == 1 && val%2 == 0){//2로 나누어 떨어질 경우
            return val/2;
        }else{
            return val-1;
        }
    }
    static void bfs(int x) {
        queue.offer(x);
        visited[x] = true;
        while(!queue.isEmpty()) {
            int a = queue.poll();
            for (int i = 0; i < 3; i++) {
                int nx = cal(a,i);
                if(nx < 0 || nx >x)continue;//범위를 벗어나면 넘김.
                if(visited[nx] || numbers[nx] != 0) continue;//이미 방문을 했거나, 0이 아니면 넘김.

                queue.offer(nx);
                numbers[nx] = numbers[a] + 1;
                visited[nx] = true;
            }
        }
    }
}
/*
DP 접근방법(여러 하위 문제를 푼 후 그 결과를 쌓아올려 주어진 문제를 해겨하는 알고리즘.)
1. 테이블을 정의하기
2. 점화식을 찾기
D[12]?
3으로 나누기 D[12] = D[4] + 1
2로 나누기 D[12] = D[6] + 1
1을 뺴기 D[12] = D[11] + 1
=> D[12] = Math.min(D[4] + 1, Math.min(D[6]+1, D[11] + 1) )
3. 초기값 설정하기
D[1] = 0
DP 문제는 많은 문제를 풀어보는 것이 중요.
 */
