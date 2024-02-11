package baekjoon.dynamicProgramming;

import java.io.*;

public class 일로만들기2_12852 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());//1보다 크거나 같고, 10^6보다 작거나 같은 자연수
        int[] numbers = new int[N + 1];//몇 번 했는지 개수를 기록
        int[] check = new int[N + 1];//이전의 값을 기록
        StringBuilder sb = new StringBuilder();
        //시작점
        numbers[1] = 0;

        for (int i = 2; i <= N; i++) {
            numbers[i] = numbers[i - 1] + 1;
            check[i] = i - 1;//Initialize check[i] to i-1

            if (i % 2 == 0 && numbers[i / 2] + 1 < numbers[i]) {
                numbers[i] = numbers[i / 2] + 1;
                check[i] = i / 2;
            }
            if (i % 3 == 0 && numbers[i / 3] + 1 < numbers[i]) {
                numbers[i] = numbers[i / 3] + 1;
                check[i] = i / 3;
            }// else if 주의. 6의 경우 6은 2로도, 3으로도 나누어떨어지기 때문에 else if를 사용할 경우 값의 갱신이 되지 않을 수 있음.
        }
        sb.append(numbers[N]).append("\n");
        sb.append(N).append(" ");
        int val = -1;
        int idx = N;
        while (true) {
            val = check[idx];//이전 값을 넣음.
            if (val == 0) break;
            idx = val;
            sb.append(val).append(" ");
        }
        System.out.println(sb);


        br.close();
    }

}
