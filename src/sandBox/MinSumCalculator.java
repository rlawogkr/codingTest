package sandBox;

import java.io.*;
import java.util.*;

/*
int[][] a = {{1,3,2},{8,7,5},{4,8,6} ... {a,b,c}};가 있다고 하자.(a,b,c는 1이상 10^6 이하의 수)
여기서 0행 중 1개의 값, 1행 중 1개의 값, ..., n행 중 1개의 값을 뽑아 더한 값이 최소가 되도록 하려고 한다.
단 a[x][0],a[y][1],a[z][2] 는 무조건 1번 이상 포함되어야 한다.(x,y,z는 0이상 n이하의 서로 같지 않은 임의의 정수).
해당 값을 만족하는 코드를 java로 작성하시오.
 */
public class MinSumCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
            array[i][2] = Integer.parseInt(st.nextToken());
        }

        int result = findMinSum(array);
        System.out.println("최소값 합: " + result);
    }

    //모든 행이 사용되었는지를 검증.
    static boolean validate(Stack<Integer> stack) {
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

        // 선택된 열을 기록하는 스택
        Stack<Integer> stack_0 = new Stack<>();
        Stack<Integer> stack_1 = new Stack<>();
        Stack<Integer> stack_2 = new Stack<>();

        // 첫 번째 행은 그대로 복사
        for (int i = 0; i < 3; i++) {
            dp[0][i] = a[0][i];
            stack_0.push(i);
            stack_1.push(i);
            stack_2.push(i);
        }

        // 동적 계획법을 이용하여 최소 합 계산
        for (int i = 1; i < n; i++) {
            dp[i][0] = a[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            if (dp[i - 1][1] > dp[i - 1][2]) {
                stack_0.push(2);
            } else {
                stack_0.push(1);
            }
            dp[i][1] = a[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            if (dp[i - 1][0] > dp[i - 1][2]) {
                stack_1.push(2);
            } else {
                stack_1.push(0);
            }
            dp[i][2] = a[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            if (dp[i - 1][0] > dp[i - 1][1]) {
                stack_2.push(1);
            } else {
                stack_2.push(0);
            }

        }
        if (!validate(stack_0)) {
            dp[n - 1][0] = Integer.MAX_VALUE;
        }
        if (!validate(stack_1)) {
            dp[n - 1][1] = Integer.MAX_VALUE;
        }
        if (!validate(stack_2)) {
            dp[n - 1][2] = Integer.MAX_VALUE;
        }
        // 마지막 행에서 최소값 찾기
        int minSum = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }


        return minSum;
    }
//    static int findMinimumSum(int[][] a) {
//        int n = a.length;
//        int[][] dp = new int[n][3];
//
//        // Initialize the first row of dp array
//        for (int i = 0; i < 3; i++) {
//            dp[0][i] = a[0][i];
//        }
//
//        // Dynamic Programming to fill the dp array
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < 3; j++) {
//                int minPrevRow = Integer.MAX_VALUE;
//                for (int k = 0; k < 3; k++) {
//                    if (k != j) {
//                        minPrevRow = Math.min(minPrevRow, dp[i - 1][k]);
//                    }
//                }
//                dp[i][j] = a[i][j] + minPrevRow;
//            }
//        }
//
//        // Find the minimum sum in the last row
//        int minSum = Integer.MAX_VALUE;
//        for (int i = 0; i < 3; i++) {
//            minSum = Math.min(minSum, dp[n - 1][i]);
//        }
//        for(int i = 0;i<n;i++){
//            for(int j = 0;j<3;j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        return minSum;
//    }

    /*
    array[n][3] = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    }

    10 10 2
    29 26 5
    32 28 6
    해당 값이 들어왔을 때 각각의 항 1개를 골라 최소값을 return 하는 함수.
    (단 1개의 행 중에서 1개의 열을 고르면 그 행의 나머지 2개의 값은 소멸한다. 그리고 결과적으로 각각의 열이 무조건 한 번 이상은 나와야 한다.)
     */

}
