package baekjoon.brutalForce;

import java.io.*;
import java.util.*;
//6064. 카잉 달력
public class Boj_6064 {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); //최대 연도 10
            int n = Integer.parseInt(st.nextToken()); //최대 월 12
            int x = Integer.parseInt(st.nextToken()); //x년 3
            int y = Integer.parseInt(st.nextToken()); //y월 9
            int count = x; // x년부터 시작
            int max = m*n;
            boolean flag = false;
            while(count<=max){
                if((count-y)%n == 0){ //count - y: x년부터 시작해서 y월이 되는 연도
                    flag = true;
                    break;
                }
                count += m; // m년씩 증가
            }
            if(flag) sb.append(count).append("\n");
            else sb.append(-1).append("\n");
        }
        System.out.print(sb);
    }
}
