package baekjoon.dynamicProgramming;

import java.io.*;

public class 타일링_11726 {
    /*
    2*n 크기의 직사각형을 1*2, 2*1 타일로 채우는 방법의 수 구하는 프로그램.
    첫쨰 줄에 2*n 크기의 직사각형 채우는 방법의 수 10,0007로 나눈 나머지 출력.
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] sum = new int[n];

        //initial value
        sum[0] = 1;
        sum[1] = 2;

        for(int i = 2;i<n;i++){
            sum[i] = (sum[i-1]+sum[i-2])%10007;
        }
        System.out.println(sum[n-1]);
        br.close();
    }
}
