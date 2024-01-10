package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 하노이탑이동순서_11729 {
    /*
    1. n-1개의 원판을 기둥 1에서 기둥 2으로 옮긴다.
    2. n번째 원판을 기둥 1에서 기둥 3으로 옮긴다.
    3. n-1개의 원판을 기둥 2에서 기둥 3으로 옮긴다.

    점화식 세우기
    1개일 때 -> 1번째 원판을 기둥 1에서 기둥 3으로 옮긴다.(1회)
    k개일 때 -> k-1개의 원판을 기둥 1에서 기둥 2로 옮긴다.(x회)
            -> k번째 원판을 기둥 1에서 기둥 3으로 옮긴다.(1회)
            -> k-1개의 원판을 기둥 2에서 기둥 3으로 옮긴다.(y회)
     */
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        System.out.println((int)Math.pow(2,n)-1);
        hanoi(n,1,3,2);

        System.out.println(sb);
        br.close();
    }
    //via는 거쳐가는 기둥
    static void hanoi(int n, int from, int to, int via){
        if(n == 1){
//            System.out.println(from + " " + to);
            sb.append(from + " " + to + "\n");
//            System.out.println("재귀 탈출: "+"n = " + n + ", from = " + from + ", to = " + to + ", via = " + via);
        }else{
            hanoi(n-1,from,via,to);//n-1개의 원판을 기둥 1에서 기둥 2로 옮긴다.
//            System.out.println(n-1+" "+from+" "+via+" "+to);
            sb.append(from + " " + to + "\n");
//            System.out.println("n번째 원판을 기둥 from에서 기둥 via으로: "+from + " " + via);//n번째 원판을 기둥 1에서 기둥 3으로 옮긴다.
            hanoi(n-1,via,to,from);//n-1개의 원판을 기둥 2에서 기둥 3으로 옮긴다.
//            System.out.println(n-1+" "+via+" "+to+" "+from);
//            System.out.println("두 번째 재귀 종료");
        }
    }
}
