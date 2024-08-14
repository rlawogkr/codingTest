package baekjoon.backtracking;

import java.io.*;
import java.util.*;

/**
 * 16987. 계란으로 계란치기
 * 계란1: 내구도가7, 무게5
 * 계란2: 내구도3, 무게4
 * 계란 1로 계란2를 치게 되면, 계란1의 내구도는 4만큼 감소해 3, 계란2의 내구도는 5만큼 감소새 -2
 * 결과: 계란 1은 깨지지 않고, 계란 2는 깨짐
 * 일렬로 놓여있는 계란에 대해 왼쪽부터 차례로 들어서 한 번씩만 다른 계란을 쳐 최대한 많은 계란을 꺠는 문제
 *
 * if(손에 든 계란이 깨졌거나 || 계란이 둘 다 안깨짐) 다음 계란으로 넘어감
 * 다음 계란 손에 들고 재귀
 * if(손에 든 계란이 가장 오른쪽에 위치할 경우) 종료
 */

public class Boj_16987 {
    static int n;
    static int[] durability;
    static int[] weight;
    static int maxCnt = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        durability = new int[n];
        weight = new int[n];
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            durability[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(maxCnt);
        br.close();
    }

    static void dfs(int idx){
        if(idx == n){
            int cnt = 0;
            for(int i = 0; i<n; i++){
                if(durability[i] <= 0) cnt++;
            }
            maxCnt = Math.max(maxCnt, cnt);
            return;
        }
        // 손에 든 계란이 깨짐
        if(durability[idx] <= 0){
            dfs(idx+1);
            return;
        }

        boolean flag = false;
        for(int i = 0; i<n; i++){
            // 내 자신 || 이미 꺠진 계란은 제외
            if(i == idx || durability[i] <= 0) continue;
            flag = true;
            durability[idx] -= weight[i];
            durability[i] -= weight[idx];
            dfs(idx+1);
            durability[idx] += weight[i];
            durability[i] += weight[idx];
        }
        // 칠 수 있는 계란 이 없을 경우 종료
        if(!flag) dfs(n);
    }
}
