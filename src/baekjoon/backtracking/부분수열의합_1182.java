package baekjoon.backtracking;

import java.io.*;
import java.util.*;


public class 부분수열의합_1182 {
    /*
    N개의 정수로 이루어진 수열. 크기가 양수인 부분수열 중 수열의 원소를 다 더한 값이 S가 되는 경우의 수
     */
    static int[] arr;
//    static boolean[] visited;
    static int N, S, count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());//1<= N <= 20
        S = Integer.parseInt(st.nextToken());//|S| <= 1000000
        arr = new int[N];
//        visited = new boolean[N];
//visited 를 사용하게 되면 {1,2,3} 일 떄, [1,2], [2,1] 이걸 다른 것으로 고려한다. 그러므로 중복으로 고려하게 된다.
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }
        count = 0;
//        backTracking(0);
        backTracking(0,0);
        if(S == 0) count--; // 공집합은 제외.
        System.out.println(count);
        br.close();
    }
    static void backTracking(int depth, int sum) {
        if (depth == N) { // depth가 N에 도달하면 부분 수열이 완성됨
            System.out.println("재귀 종료// depth:"+depth+" sum:"+sum);
            if (sum == S) {
                count++;
            }
            return;
        }
        System.out.println("depth: "+depth+" sum: "+sum);
        // 현재 원소를 선택하는 경우

        backTracking(depth + 1, sum + arr[depth]);
        System.out.println("depth: "+depth+" arr[depth]: "+arr[depth]);
        // 현재 원소를 선택하지 않는 경우

        backTracking(depth + 1, sum);
    }


//    static void backTracking(int depth) {
//        if (depth == N) { // depth가 N에 도달하면 부분 수열이 완성됨
//            int tempSum = 0;
//            for (int i = 0; i < N; i++) {
//                if (visited[i]) {
//                    tempSum += arr[i];
//                }
//            }
//            if(tempSum == S)count++;
//
//            return;
//        }
//
//        // 현재 원소를 선택하는 경우
//        visited[depth] = true;
//        backTracking(depth + 1);
//
//        // 현재 원소를 선택하지 않는 경우
//        visited[depth] = false;
//        backTracking(depth + 1);
//    }

}