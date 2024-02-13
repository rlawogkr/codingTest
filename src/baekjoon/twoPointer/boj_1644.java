package baekjoon.twoPointer;

import java.io.*;
import java.util.*;

/**
 * '하나 이상'의 '연속된 소수의 합'으로 나타낼 수 있는 자연수.
 * 한 소수는 반드시 한 번만 덧셈에 사용될 수 있음.
 */
public class boj_1644 {
    static List<Integer> list = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());//sum이 돼야 하는 수.

        if (n == 1) {
            System.out.println(0);
            return;
        }
        putVal(n);

        int sum = 0;
        int left = 0;
        int res = 0;
        for (int right = 0; right < list.size(); right++){
                sum += list.get(right);
                while(sum >= n){
                    if(sum == n){
                        res++;
                        break;
                    }
                    sum -= list.get(left);
                    left++;
                }
        }

        System.out.println(res);

        br.close();
    }

    //n보다 작은 모든 소수를 decimal에 넣음.
    static void putVal(int n) {

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                list.add(i);
            }
        }
    }

}
