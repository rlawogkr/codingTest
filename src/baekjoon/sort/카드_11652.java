package baekjoon.sort;

import java.io.*;
import java.util.*;

public class 카드_11652 {
    static int n;//1<=n<=100,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();
        List<Long> list = new ArrayList<>();

        //HashMap에 값을 집어넣음.
        for (int i = 0; i < n; i++) {
            Long key = Long.parseLong(br.readLine());
            list.add(key);
            if (map.containsKey(key)) {
                int value = map.get(key);
                map.put(key, ++value);
            } else {
                map.put(key, 1);
            }
        }
        Collections.sort(list);
        Iterator<Long> iterator = list.iterator();

        int tmp = 0;
        Long res = 0L;
        while(iterator.hasNext()){
            Long key = iterator.next();
            if(map.get(key) > tmp){
                tmp = map.get(key);
                res = key;
            }
        }
        System.out.println(res);
        br.close();
    }
}
