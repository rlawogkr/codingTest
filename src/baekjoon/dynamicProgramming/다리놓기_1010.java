package baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        //m Combination n
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(combination(n, m)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
    static long combination(int n, int m) {
        if (n == 0 || m == n) return 1L;
        //분모
        long parent;
        long son;
        //분자
        if (m - n > n) {
            son = factorial(m,m-n);
            parent = factorial(n,0);
        } else{
            son = factorial(m,n);
            parent = factorial(m-n,0);
        }
        return son/parent;
    }

    static long factorial(int start, int end) {
        long res = 1L;
        while (start > end) {
            res *= start;
            start--;
        }
        return res;
    }


}



