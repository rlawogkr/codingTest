package baekjoon.dynamicProgramming;
import java.io.*;
import java.util.*;
//11726 2*n 타일링
public class Boj_11726 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        if(n==1) System.out.print(1);
        else if(n==2) System.out.print(2);
        else{
            dp[1] = 1;
            dp[2] = 2;
            for(int i=3; i<=n; i++){
                dp[i] = (dp[i-1] + dp[i-2])%10007;
            }
            System.out.print(dp[n]);
        }
        br.close();
    }
}
