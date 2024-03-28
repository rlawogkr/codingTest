package baekjoon.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_2493 {
    static int[] tower;
    static Stack<Node> stack = new Stack<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());//갯수
        StringTokenizer st = new StringTokenizer(br.readLine());
        tower = new int[n];
        for(int i = 0;i<n;i++){
            tower[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<n; i++){
            while(!stack.isEmpty()){
                if(stack.peek().height >= tower[i]){
                    System.out.print((stack.peek().idx + 1)+" ");
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()){
                System.out.print("0 ");
            }
            stack.push(new Node(i, tower[i]));
        }


        br.close();
    }

    static class Node{
        int idx;
        int height;

        public Node(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
}
