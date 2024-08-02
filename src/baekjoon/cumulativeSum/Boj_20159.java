package baekjoon.cumulativeSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 20159. 동작 그만. 밑장 빼기.
// 최대 한 번 및장 빼기. 얻을 수 있는 최대 카드의 합
public class Boj_20159 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];
        String[] s = br.readLine().split(" ");

        for(int i = 0; i<n; i++) {
            cards[i] = Integer.parseInt(s[i]);
        }



        int[] prefixSum = new int[n]; // prefixSum[i]: 0~i까지의 카드 합
        int[] suffixSum = new int[n]; // suffixSum[i]: i~n-1까지의 카드 합

        prefixSum[0] = cards[0];
        suffixSum[n-1] = cards[n-1];
        for(int i = 1; i<n; i++) {
            prefixSum[i] = prefixSum[i-1] + cards[i];
            suffixSum[n-1-i] = suffixSum[n-i] + cards[n-1-i];
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i<n-1; i++) {
            // i 번째 카드를 빼는 경우
            int sum = prefixSum[i] + suffixSum[i+1];
            if(sum > max) max = sum;

        }

        System.out.println(max);


        br.close();
    }
}
