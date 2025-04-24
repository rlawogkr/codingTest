package baekjoon.collections;
import java.util.*;
import java.io.*;

public class Boj_9375 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // testcase
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine()); // 의상 수
            Map<String, List<String>> map = new HashMap<>(); // map 초기화
            for(int j = 0; j < n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String value = st.nextToken();
                String key = st.nextToken();
                if(!map.containsKey(key)){
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(value);
            }
            int res = 1;
            for(String key : map.keySet()){
                res *= map.get(key).size() + 1;
            }
            sb.append(res -1).append("\n"); // 아무것도 입지 않은 경우 제외
        }
        System.out.println(sb.toString());
        br.close();
    }
}
