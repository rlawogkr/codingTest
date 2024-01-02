package baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열_11053 {

    static int[] dp;
    static int[] a;
    //LIS(최장증가부분수열) 문제
    /*
    10    20        10    30          20       50
    1{10} 2{10,20}  1{10} 3{10,20,30} 2{10,20} 4{10,20,30,40}
    */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        dp = memorize(a);
        Arrays.sort(dp);
        System.out.println(dp[dp.length-1]);

        br.close();
    }

    //Buttom-Up 방식으로 구현(반복문)
    static int[] memorize(int[] a){
        int[] dp = new int[a.length];

        for(int i = 0;i<dp.length;i++){
            dp[i] = 1;
            //0~i-1까지 값과 i를 비교, 가장 큰 값의 dp에 1을 더한 값을 dp[i]에 넣음.
            for(int j = 0;j<i;j++){
                //j번째 원소가 i번쨰 원소보다 작으면서, i번째 dp가 j번째 dp + 1 보다 작은 경우
                if(a[j] < a[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
        }
        return dp;
    }



}
