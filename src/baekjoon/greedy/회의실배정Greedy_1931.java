package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실배정Greedy_1931 {
    static int N;//회의의 수. 1<= N <= 100,000
    static int[][] conferences;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        conferences = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            conferences[i][0] = Integer.parseInt(st.nextToken());
            conferences[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(conferences, (a, b) ->
        {
            //종료시간이 같을 경우 시작시간이 빠른 값으로 정렬
            if (a[1] == b[1]) return a[0]-b[0];//return Integer.compare(a[0],b[0])
                //첫 번째 열값이 같을 경우 두 번째 열값으로 비교
            else return a[1]-b[1];//return Inter.compare(a[1],b[1])
        });



        int count = 1;
        int endTime = conferences[0][1];
        for (int i = 1; i < N; i++) {
            if (conferences[i][0] >= endTime) {
                count++;
                endTime = conferences[i][1];
            }
        }
        System.out.println(count);

        br.close();
    }
}

