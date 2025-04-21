package baekjoon.collections;
import java.util.*;
import java.io.*;

public class Boj_9536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            // 1) 녹음된 소리 리스트
            String[] sounds = br.readLine().split(" ");

            // 2) 제외할(다른 동물의) 울음소리 집합
            Set<String> exclude = new HashSet<>();

            // 3) “what does the fox say?” 전까지 읽으며 exclude 채우기
            while (true) {
                String line = br.readLine();
                if (line.equals("what does the fox say?")) break;

                // “<동물> goes <소리>”
                String[] parts = line.split(" ");
                String animalSound = parts[2];
                exclude.add(animalSound);
            }

            // 4) 원본 순서대로 걸러내어 출력
            StringBuilder sb = new StringBuilder();
            for (String s : sounds) {
                if (!exclude.contains(s)) {
                    sb.append(s).append(' ');
                }
            }
            // 맨 끝 공백 제거하고 한 줄로 출력
            System.out.println(sb.toString());
        }

        br.close();
    }
}