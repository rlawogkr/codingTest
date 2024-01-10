package baekjoon.recursion;

import java.io.*;
import java.util.*;

public class 종이의개수_1780 {
    static int[][] paper;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
    }
}
