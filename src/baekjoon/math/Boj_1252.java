package baekjoon.math;
import java.util.*;
import java.io.*;
import java.math.*;

public class Boj_1252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        // 2진수를 BigInteger로 변환
        BigInteger a = new BigInteger(s[0], 2);
        BigInteger b = new BigInteger(s[1], 2);

        // 두 수를 더함
        BigInteger res = a.add(b);

        // 결과를 2진수 문자열로 출력
        System.out.println(res.toString(2));
        br.close();
    }
}
