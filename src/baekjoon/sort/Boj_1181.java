package baekjoon.sort;

import java.io.*;
import java.util.*;

public class Boj_1181 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len = o1.length() - o2.length();
                if (len == 0) return o1.compareTo(o2);
                else return len;
            }
        });

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        for (String s : set) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
