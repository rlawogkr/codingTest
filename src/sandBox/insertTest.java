package sandBox;

import java.io.*;
import java.util.*;
public class insertTest {
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
//                continue;//다음 iteration 으로 넘김.
            }

            Arrays.sort(agent, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });
            System.out.println("o2[0] - o1[0]");
            for(int i = 0;i<n;i++){
                for(int j = 0;j<3;j++){
                    System.out.print(agent[i][j] + " ");
                }
                System.out.println();
            }

            Arrays.sort(agent, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });
            System.out.println("o2[1] - o1[1]");
            for(int i = 0;i<n;i++){
                for(int j = 0;j<3;j++){
                    System.out.print(agent[i][j] + " ");
                }
                System.out.println();
            }
            Arrays.sort(agent, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[2] - o1[2];
                }
            });
            System.out.println("o2[2] - o1[2]");
            for(int i = 0;i<n;i++){
                for(int j = 0;j<3;j++){
                    System.out.print(agent[i][j] + " ");
                }
                System.out.println();
            }
            Arrays.sort(agent, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });
            System.out.println("o2[0] - o1[0]");
            for(int i = 0;i<n;i++){
                for(int j = 0;j<3;j++){
                    System.out.print(agent[i][j] + " ");
                }
                System.out.println();
            }
            Arrays.sort(agent, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });
            System.out.println("o2[1] - o1[1]");
            for(int i = 0;i<n;i++){
                for(int j = 0;j<3;j++){
                    System.out.print(agent[i][j] + " ");
                }
                System.out.println();
            }
            Arrays.sort(agent, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[2] - o1[2];
                }
            });
            System.out.println("o2[2] - o1[2]");
            for(int i = 0;i<n;i++){
                for(int j = 0;j<3;j++){
                    System.out.print(agent[i][j] + " ");
                }
                System.out.println();
            }

        }
//        System.out.println("sb:"+sb);
        br.close();

    }

}

/*
            Arrays.sort(agent, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });
            //최정예 요원들의 능력치를 내림차순으로 정렬
            Arrays.sort(agent, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });
            //최정예 요원들의 능력치를 내림차순으로 정렬
            Arrays.sort(agent, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[2] - o1[2];
                }
            });
            //최정예 요원들의 능력치를 내림차순으로 정렬
            Arrays.sort(agent, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });
            //최정예 요원들의 능력치를 내림차순으로 정렬
            Arrays.sort(agent, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });
            //최정예 요원들의 능력치를 내림차순으로 정렬
            Arrays.sort(agent, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[2] - o1[2];
                }
            });
            //최정예 요원들의 능력치를 내림차순으로 정
            int res = 0;
            for (int i = 0; i < n; i++) {
                res += agent[i][0] + agent[i][1] + agent[i][2];
            }
            sb.append("#").append(tc).append(" ").append(res).append("\n");
 */


