package baekjoon.binarySearch;

import java.util.*;
import java.io.*;
//가장 인접한 두 공유기 사이의 거리를 최대로

public class Boj_2110 {
    static int[] home;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//집의 개수
        int c = Integer.parseInt(st.nextToken());//공유기의 개수
        home = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            home[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(home);


        br.close();
    }
}
