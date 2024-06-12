package baekjoon.dataStructure;

import java.io.*;
import java.util.*;

public class Boj_22252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());        // 쿼리의 개수

        Map<String, ArrayList<Integer>> map = new HashMap<>();      // Key : 고릴라의 이름, Value : 정보의 가치

        long total = 0;
        StringTokenizer st;
        for (int i = 0; i < q; i++) {                       // 쿼리 순회
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            String name = st.nextToken();                     // 고릴라 이름
            int num = Integer.parseInt(st.nextToken());       // 정보의 개수

            if (!map.containsKey(name)) {                     // 처음 등장한 고릴라라면
                map.put(name, new ArrayList<>());
            }

            if (type == 1) {                                  // 정보를 얻은 정보 고릴라의 이름과 정보 가치 제공
                for (int j = 0; j < num; j++) {                 // 보유하고 있는 정보의 개수
                    map.get(name).add(Integer.parseInt(st.nextToken()));
                }
            } else if (type == 2) {           // 호석이가 이름이 [Name]인 고릴라에게 num개의 정보를 구매
                while (!map.get(name).isEmpty() && num > 0) {
                    if (map.get(name).get(0) == null) continue;

                    total += map.get(name).get(0);        // 내림차순으로 정렬한 리스트의 첫번째 요소 더하기
                    map.get(name).remove(0);              // 첫번째 요소 지우기
                    num--;
                }

            }

            Collections.sort(map.get(name), Collections.reverseOrder());      // map.get(name)으로 얻은 list를 내림차순으로 정렬
        }
        System.out.println(total);
    }
}