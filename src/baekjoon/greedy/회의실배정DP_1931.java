package baekjoon.greedy;

import java.util.*;
import java.io.*;


public class 회의실배정DP_1931 {
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
            //첫 번째 열값을 기준으로 비교
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);//a가 b보다 작으면 음수 리턴. a가 b보다 크면 양수 리턴.
                //첫 번째 열값이 같을 경우 두 번째 열값으로 비교
            else return Integer.compare(a[1], b[1]);
        });

        int[] D = new int[N];
        //DP 로 1개씩 해결
        D[0] = 1; // 초기값. 첫 번쨰 회의는 무조건 1.

        for (int i = 1; i < D.length; i++) {
            D[i] = 1;//초기값 설정
            for(int j = 0; j<i;j++){
                if(conferences[j][1] <= conferences[i][0]){ //이전 회의가 이후 회의 시작하는 시간보다 빨리 끝날 때
                    D[i] = Math.max(D[i], D[j]+1);//i번째 회의를 선택했을 떄와 선택하지 않았을 때 중 큰 값으로 갱신
                }
            }
        }
        System.out.println(D[N-1]);

        br.close();
    }
}












