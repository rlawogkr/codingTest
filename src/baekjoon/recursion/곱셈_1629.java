package baekjoon.recursion;

import java.io.*;
import java.util.*;

public class 곱셈_1629 {
    /*
    자연수 A를 B번 곱한 수를 C로 나눈 나머지
    modular 산술연산은 분배법칙이 성립힌다.
    (A+B)%C = (A%C + B%C)%C
    (A*B)%C = (A%C * B%C)%C
    (A-B)%C = (A%C - B%C)%C
     */
    static Long a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.println(modular(a,b,c));

        br.close();
    }

    static Long modular(Long a, Long b, Long c){
        if(b == 1){
            return a%c;
        }//탈출 조건.
        Long tmp = modular(a,b/2,c);
        if(b%2 == 0){//b가 짝수일 때
            return (tmp*tmp)%c;
        }else{//b가 홀수일 때
            return (((tmp*tmp)%c)*a%c)%c;
        }
    }



}
