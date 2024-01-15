package baekjoon.recursion;

import java.io.*;
import java.util.*;

public class Z_1074 {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//1<=n<=15
        int r = Integer.parseInt(st.nextToken());//row
        int c = Integer.parseInt(st.nextToken());//column

        int area = findValue(n,r,c);
        System.out.println(area);
        br.close();
    }
    //1<=n<=15. row 와 column
    static int findValue(int n, int r, int c){
        //Base condition
        if(n==0){
            return 0;
        }
        int half = (int) Math.pow(2, n - 1);
        if(r<half && c<half){//1사분면
            return findValue(n-1,r,c);
        }else if(r<half && c>=half){//2사분면
            return findValue(n-1,r,c-half)+half*half;
        }else if(r>=half && c<half){//3사분면
            return findValue(n-1,r-half,c)+half*half*2;
        }else{//4사분면
            return findValue(n-1,r-half,c-half)+half*half*3;
        }

    }
}
