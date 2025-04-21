package baekjoon.dynamicProgramming;
import java.io.*;
import java.util.*;

public class Boj_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        boolean[] win = new boolean[N+1];
        win[0] = false;
        for (int k = 1; k <= N; k++) {
            boolean w1 = (k >= 1) && !win[k-1];
            boolean w3 = (k >= 3) && !win[k-3];
            win[k] = w1 || w3;
        }

        System.out.println(win[N] ? "SK" : "CY");
    }
}