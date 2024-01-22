package baekjoon.dynamicProgramming;

import java.io.*;
import java.util.*;

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
public class MakeOne_1463 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        arr[1] = 0;
        for(int i = 2; i<=n ; i++){
            arr[i] = arr[i-1] + 1;
            if(i%2 == 0) arr[i] = Math.min(arr[i],arr[i/2]+1);
            if(i%3 == 0) arr[i] = Math.min(arr[i],arr[i/3]+1);
        }
        System.out.println(arr[n]);
        br.close();
    }
}
