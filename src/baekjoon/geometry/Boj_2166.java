package baekjoon.geometry;
import java.util.*;
import java.io.*;

// 소수점 첫째자리까지 출력
public class Boj_2166 {

    static class Node{
        long x;
        long y;
        Node(long x, long y){
            this.x = x;
            this.y = y;
        }
        public long getX(){
            return x;
        }
        public long getY(){
            return y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n+1];
        double res = 0; // 정확한 계산을 위해 float보다 double을 사용하는 것이 적합하다.

        // 값 초기화
        for(int i = 0; i<n; i++){
            String[] s = br.readLine().split(" ");
            if(i == 0){
                nodes[0] = new Node(Long.parseLong(s[0]), Long.parseLong(s[1]));
                nodes[n] = new Node(Long.parseLong(s[0]), Long.parseLong(s[1]));
            }else{
                nodes[i] = new Node(Long.parseLong(s[0]), Long.parseLong(s[1]));
            }
        }
        for(int i = 0; i<n; i++){
            res += nodes[i].getX()*nodes[i+1].getY() - nodes[i].getY() * nodes[i+1].getX();
        }
        res = Math.abs(res) / 2;


        System.out.printf(String.format("%.1f",res));
    }
}
