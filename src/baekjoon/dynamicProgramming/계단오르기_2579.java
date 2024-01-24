package baekjoon.dynamicProgramming;

import java.io.*;
import java.util.*;

public class 계단오르기_2579 {

    //ladder[i][j] : 현재까지 j개의 계단을 연속해서 밟고, i번째 계단까지 올라섰을 때 점수 합의 최대값.
    // i번쨰 계단은 반드시 밟아야 함.
    static int[][] ladder;
    static int[] values;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nums = Integer.parseInt(br.readLine());
        ladder = new int[nums][3];//2번까지 계단을 연속해서 밟을 수 있음.
        values = new int[nums];

        for(int i = 0;i<nums;i++){
            values[i] = Integer.parseInt(br.readLine());
        }
        /*
        ladder[k][1] = Math.max(ladder[k-2][1] , ladder[k-2][2]) + values[k] // 그 전에 값을 밟으면 안됨.
        ladder[k][2] = ladder[k-1][1] + values[k] //그 전에 값을 밟아야 함. 그 전 값이 2이면 안됨.
        return: Math.max( ladder[k][1], ladder[k][2] )
         */
        //initial value
        ladder[0][1] = values[0];
        ladder[0][2] = 0;//값이 없음
        if(nums > 1) {
            ladder[1][1] = values[1];
            ladder[1][2] = values[0] + values[1];
        }
        for(int k = 2;k<nums;k++){
            ladder[k][1] = Math.max(ladder[k-2][1] , ladder[k-2][2]) + values[k];
            ladder[k][2] = ladder[k-1][1] + values[k];
        }
        int res = Math.max(ladder[nums-1][1], ladder[nums-1][2]);
        System.out.println(res);

        br.close();
    }
}
