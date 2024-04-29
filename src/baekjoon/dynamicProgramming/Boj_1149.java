package baekjoon.dynamicProgramming;

import java.io.*;
import java.util.*;

public class Boj_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] RGB = new int[N][3];
          for(int i = 0;i<N;i++){
              String[] strings = br.readLine().split(" ");
              RGB[i][0] = Integer.parseInt(strings[0]);//Red
              RGB[i][1] = Integer.parseInt(strings[1]);//Green
              RGB[i][2] = Integer.parseInt(strings[2]);//Blue
          }


          int[][] sum = new int[N][3];

          sum[0][0] = RGB[0][0];
          sum[0][1] = RGB[0][1];
          sum[0][2] = RGB[0][2];
          // RGB[i][j]: i번째 집을 j로 칠했을 때의 비용
          // sum[i][j]: i번째 집을 j로 칠했을 때의 최소값
          for(int i = 1;i<N;i++){
              sum[i][0] = RGB[i][0] + Math.min(sum[i-1][1],sum[i-1][2]);
              sum[i][1] = RGB[i][1] + Math.min(sum[i-1][0],sum[i-1][2]);
              sum[i][2] = RGB[i][2] + Math.min(sum[i-1][0],sum[i-1][1]);
          }

          System.out.println(Math.min(sum[N-1][0],Math.min(sum[N-1][1],sum[N-1][2])));
          br.close();
      }

}
