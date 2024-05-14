package baekjoon.dynamicProgramming;

import java.util.*;
import java.io.*;
//1107.리모컨
public class Boj_1107 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());//채널 n
        int m = Integer.parseInt(br.readLine());//고장난 버튼의 개수
        boolean[] broken = new boolean[10];//고장난 버튼

        if(m!=0){// 고장난 버튼이 있을 때
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0;i<m;i++){
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int ans = Math.abs(n-100);//초기값: +,- 버튼만을 이용해서 이동하는 경우
        for(int i = 0;i<=1000000;i++){
            int count = counter(i, broken);//i번 채널로 이동할 수 있는지 확인
            if(count>0){
                int press = Math.abs(i-n);//i번 채널에서 n번 채널로 이동하는데 눌러야 하는 버튼의 수
                ans = Math.min(ans, count+press);
            }
        }
        System.out.print(ans);


       br.close();
    }
    //c: 이동하려는 채널, broken: 고장난 버튼
    //return하는 값? c로 이동할 수 있는지 확인하고, 이동할 수 있다면 눌러야 하는 버튼의 수
    public static int counter(int c, boolean[] broken){
        if(c==0){
            if(broken[0]) return 0;
            else return 1;
        }
        int count = 0;//버튼을 누르는 횟수
        while(c>0){
            if(broken[c%10]) return 0;//고장난 버튼이 있으면 0을 반환
            count++;
            c/=10;
        }
        return count;
    }
}
