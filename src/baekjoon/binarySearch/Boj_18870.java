package baekjoon.binarySearch;

import java.io.*;
import java.util.*;

public class Boj_18870 {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new LinkedHashSet<>();
        Map<Object, Integer> map = new HashMap<>();

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        int[] clone = arr.clone();
        Arrays.sort(clone);// -10 -9 2 4 4
        //중복 제거
        for (int i : clone) {
            set.add(i);//key
        }
        Iterator<Integer> itr = set.iterator();
        //key, value 세팅
        for (int i = 0; i < set.size(); i++) {
            map.put(itr.next(), i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(map.get(i)).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}
