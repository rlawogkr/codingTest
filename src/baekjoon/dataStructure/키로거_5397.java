package baekjoon.dataStructure;

import java.util.*;
import java.io.*;

public class 키로거_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if (c == '<') {
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                } else if (c == '>') {
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                } else if (c == '-') {
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                } else {
                    left.push(c);
                }
            }
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}