package baekjoon.backtracking;

import java.io.*;
import java.util.*;

/**
 * n개 수와 n-1개의 연산자가 주어질 때, 만들 수 있는 식의 결과의 최댓값과 최솟값을 구하기.
 * 연산자는 덧셈(+), 뺄셈(-), 곱셈(*), 나눗셈(/).
 * 연산자는 무조건 앞에서부터.
 */
public class boj_14888 {
    static int n;
    static int[] operators;
    static int[] nums;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        operators = new int[4];

        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());//덧셈(+), 뺄셈(-), 곱셈(*), 나눗셈(/).
        }
        backtracking(0, nums[0]);
        System.out.println(max);
        System.out.println(min);

        br.close();
    }


    static void backtracking(int idx, int result) {
        if (idx == n - 1) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                backtracking(idx + 1, calculate(result, nums[idx + 1], i));
                operators[i]++;
            }
        }
    }

    static int calculate(int a, int b, int operator) {
        if (operator == 0) {
            return a + b;
        } else if (operator == 1) {
            return a - b;
        } else if (operator == 2) {
            return a * b;
        } else {
            if (a < 0 && b > 0) return -((-a) / b);
            else return a / b;
        }
    }
}
