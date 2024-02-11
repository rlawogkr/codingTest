package baekjoon.greedy;

import java.util.*;
import java.io.*;
/*
1. 관찰을 통해 탐색 범위를 줄이는 방법을 고안.
2. 탐색 범위를 줄여도 올바른 결과를 낸다는 사실을 수학적으로 증명.
3. 구현해서 문제를 통과.
 */

/**
 * DP 풀이: D[i] = 가치의 합을 i로 만들 때 필요한 동전 개수의 최솟값
 * D[i] = min(D[i-A1], D[i-A2], ... D[i-AN]) + 1 // 시간초과 발생(A1, A2 ... AN : 동전)
 */
public class 동전영_11047 {
    static int N, K;
    static int[] coins;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());//동전의 종류 수
        K = Integer.parseInt(st.nextToken());//targetValue

        coins = new int[N];
        //내림차순 정렬
        for(int i = N-1;i>=0;i--){
            coins[i] = Integer.parseInt(br.readLine());
        }
        greedy();
        br.close();
    }

    static void greedy(){
        int count = 0;
        while(K != 0){
            for(int i = 0;i<N;i++){
                if(K < coins[i])continue;
                else{
                    count++;
                    K -= coins[i];
                    while(K >= coins[i]){
                        count++;
                        K -= coins[i];
                    }
                }
            }
        }
        System.out.println(count);
    }
}
