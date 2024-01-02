package baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;

public class 피보나치수2_2748 {
    //0 1 1 2 3 5 8 13 21 34 55 89 144 233 377
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(fibo(n));
        br.close();
    }

    static long fibo(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fibo(n-1) + fibo(n-2);
    }
}
