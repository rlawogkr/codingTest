package swea.winterAlgorithmTest;

import java.io.*;
import java.util.*;

/*
로봇 가동을 위해 최정예 요원 필요.
인류는 n명의 최정예 요원을 보유하고 있음.
최정예요원: 힘(ai), 지능(bi), 민첩(ci)를 갖고 있음.

최정예 요원은 자신이 가지고 있는 능력치 중 하나만 로봇에 공유할 수 있음. 공유하지 않은 나머지 두 능력치는 소멸.

로봇의 소멸 능력치: 로봇의 힘(ai) + 로봇의 지능(bi) + 로봇의 민첩(ci) - 최정예 요원이 공유한 능력치
 */
public class ai의반란최후의전쟁 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] agent = new int[n][3];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    agent[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //로봇을 가동할 수 없을 경우(능력치를 공유할 수 없을 경우) -1을 출력
            if (n < 3) {
                sb.append("#").append(tc).append(" ").append(-1).append("\n");
                continue;//다음 iteration 으로 넘김.
            }
            //1개씩 없애는 배열 생성
            int[][] sumAgent = new int[n][3];
            for (int i = 0; i < n; i++) {
                sumAgent[i][0] = agent[i][1] + agent[i][2];
                sumAgent[i][1] = agent[i][0] + agent[i][2];
                sumAgent[i][2] = agent[i][0] + agent[i][1];
            }
            int minDestruction = findMinSum(sumAgent);
            sb.append("#").append(tc).append(" ").append(minDestruction).append("\n");

        }
        System.out.println(sb);
        br.close();

    }

    static Stack<Integer> stack_0 = new Stack<>();
    static Stack<Integer> stack_1 = new Stack<>();
    static Stack<Integer> stack_2 = new Stack<>();

    //    private static boolean isValidSelection(int[][] selected) {
//        int n = selected.length;
//        Stack<Integer> visitedColumns = new Stack<>();
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (selected[i][j] > 0) {
//                    int currentColumn = j;
//
//                    // 현재 열이 이미 방문된 열인지 확인
//                    if (visitedColumns.contains(currentColumn)) {
//                        return false; // 중복된 열이 있으면 유효하지 않음
//                    } else {
//                        visitedColumns.push(currentColumn);
//                    }
//                }
//            }
//
//            // 스택 비우기 (다음 행을 위해)
//            visitedColumns.clear();
//        }
//
//        return true;
//    }
    static boolean isValidSelection(Stack<Integer> stack) {
        int[] check = {0, 1, 2};
        for (int i = 0; i < 3; i++) {
            if (stack.contains(check[i])) {
                return true;
            }
        }
        return false;
    }

    public static int findMinSum(int[][] a) {
        int n = a.length;

        // dp 배열 초기화
        int[][] dp = new int[n][3];

        // 선택된 열을 기록하는 배열
//        int[][] selected = new int[n][3];

        // 첫 번째 행은 그대로 복사
        for (int i = 0; i < 3; i++) {
            dp[0][i] = a[0][i];
//            selected[0][i] = 1;
            stack_0.push(i);
            stack_1.push(i);
            stack_2.push(i);
        }


        // 동적 계획법을 이용하여 최소 합 계산
        for (int i = 1; i < n; i++) {
            dp[i][0] = a[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = a[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = a[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            if (dp[i - 1][1] > dp[i - 1][2]) {
                stack_0.push(2);
            } else {
                stack_0.push(1);
            }
            if (dp[i - 1][0] > dp[i - 1][2]) {
                stack_1.push(2);
            } else {
                stack_1.push(0);
            }
            if (dp[i - 1][0] > dp[i - 1][1]) {
                stack_2.push(1);
            } else {
                stack_2.push(0);
            }
            stack_0.push(0);
            stack_1.push(1);
            stack_2.push(2);


//            // 최소값을 선택한 열 기록
//            if (dp[i][0] <= dp[i][1] && dp[i][0] <= dp[i][2]) {
//                selected[i][0] = 1;
//            } else if (dp[i][1] <= dp[i][0] && dp[i][1] <= dp[i][2]) {
//                selected[i][1] = 1;
//            } else {
//                selected[i][2] = 1;
//            }
        }

        // 모든 열이 최소 한 번 이상 선택되었는지 확인
        if (!isValidSelection(stack_0)) {
            return Integer.MAX_VALUE; // 유효한 선택이 없을 경우 -1 반환 또는 예외 처리
        }
        if (!isValidSelection(stack_1)) {
            return Integer.MAX_VALUE; // 유효한 선택이 없을 경우 -1 반환 또는 예외 처리
        }
        if (!isValidSelection(stack_2)) {
            return Integer.MAX_VALUE; // 유효한 선택이 없을 경우 -1 반환 또는 예외 처리
        }

        // 마지막 행에서 최소값 찾기
        int minSum = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));

        return minSum;
    }

}
