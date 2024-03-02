package baekjoon.sort;

import java.io.*;
import java.util.*;

public class Boj_1108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);// 1 1 2 3 4

        StringBuilder sb = new StringBuilder();
        //1. n개의 수의 합을 n으로 나눈 값.
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        sb.append((int)Math.round((double) sum / n)).append("\n");

        //2.오름차순으로 나열했을 때 중앙에 위치하는 값
        sb.append(arr[n / 2]).append("\n");

        //3. 최빈값 중 두번째로 작은 값을 출력
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
            int freq = o2.getValue() - o1.getValue();
            if (freq == 0) return o1.getKey() - o2.getKey();
            return freq;
        });
        if (list.size() > 1 && list.get(0).getValue().equals(list.get(1).getValue())) {
            sb.append(list.get(1).getKey()).append("\n");
        } else {
            sb.append(list.get(0).getKey()).append("\n");
        }


        //4. 최대값과 최소값의 차이
        sb.append(arr[n - 1] - arr[0]);

        System.out.println(sb);

        br.close();
    }
}
