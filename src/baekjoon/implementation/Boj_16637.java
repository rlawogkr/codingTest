package baekjoon.implementation;

import java.io.*;

public class Boj_16637 {
    static int n, result;
    static char[] input;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        input = new char[n];

        input = br.readLine().toCharArray();

        result = Integer.MIN_VALUE;
        // 2번 인덱스의 숫자 (2번째 숫자)부터 괄호를 내 왼쪽에 칠건지(결국 안치는게 됨) 오른쪽에 칠건지 치지 않을건지
        solve(2, input[0] - '0');
        System.out.println(result);
    }

    static void solve(int idx, int sum) {

        if (idx >= n) {
            result = Math.max(result, sum);
            return;
        }

        // 괄호 안 친 경우 지금까지의 합과 나를 계산한 결과를 다음 숫자 (index는 +2)에 넘긴다
        solve(idx+2, cal(sum, input[idx]-'0', input[idx-1]));

        // 오른쪽에 괄호 친 경우
        if (idx + 2< n) {
            // 옆 괄호 먼저 계산
            int right = cal(input[idx]-'0', input[idx+2]-'0' , input[idx+1]);
            // 지금까지 결과와 합하기
            int left = cal(sum, right, input[idx-1]);
            solve(idx+4, left);
        }
    }

    static int cal(int a, int b, char op) {
        if (op == '+') return a + b;
        else if (op == '-') return a - b;
        else return a * b;
    }
}
