package baekjoon.dataStructure;

import java.io.*;
import java.util.*;

public class StackSequence_1874 {
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0;
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append("+").append("\n");
            while (!stack.isEmpty() && stack.peek() == arr[idx]) {
                stack.pop();
                sb.append("-").append("\n");
                idx++;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }

    }
}

