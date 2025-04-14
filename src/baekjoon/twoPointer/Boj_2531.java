package baekjoon.twoPointer;package
import java.io.*;
import java.util.*;

public class Boj_2531 {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 회전 초밥 벨트에 놓인 접시의 수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가지 수 (사용하지 않지만 d 범위 확인용)
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        // 초밥 배열 입력 받기
        int[] dishes = new int[N];
        for (int i = 0; i < N; i++) {
            dishes[i] = Integer.parseInt(br.readLine());
        }

        // HashMap을 이용하여 현재 윈도우 내 초밥의 빈도를 관리
        HashMap<Integer, Integer> map = new HashMap<>();
        int distinct = 0; // 현재 윈도우 내 고유 초밥 종류의 수

        // 초기 윈도우(인덱스 0부터 k-1까지) 설정
        for (int i = 0; i < k; i++) {
            int sushi = dishes[i];
            if (map.getOrDefault(sushi, 0) == 0) {
                distinct++;
            }
            map.put(sushi, map.getOrDefault(sushi, 0) + 1);
        }

        // 쿠폰 초밥 적용: 초기 윈도우에 쿠폰 초밥이 없다면 결과에 1종 추가
        int ans = distinct;
        if (map.getOrDefault(c, 0) == 0) {
            ans++;
        }

        // 슬라이딩 윈도우 진행 (원형 배열 처리)
        for (int i = 0; i < N; i++) {
            // 윈도우의 시작점에 해당하는 초밥 제거
            int removeSushi = dishes[i];
            int count = map.get(removeSushi);
            if (count == 1) {   // 이제 윈도우 안에 해당 값이 없음
                map.remove(removeSushi);
                distinct--;
            } else {            // 아직 윈도우 안에 해당 값이 있음
                map.put(removeSushi, count - 1);
            }

            // 새롭게 들어오는 접시는 (i + k) % N 인덱스의 초밥
            int nextIndex = (i + k) % N;
            int nextSushi = dishes[nextIndex];
            if (map.getOrDefault(nextSushi, 0) == 0) {
                distinct++;
            }
            map.put(nextSushi, map.getOrDefault(nextSushi, 0) + 1);

            // 현재 윈도우의 결과 계산 (쿠폰 적용)
            int current = distinct;
            if (map.getOrDefault(c, 0) == 0) {
                current++;
            }
            ans = Math.max(ans, current);
        }

        // 결과 출력
        System.out.println(ans);
        br.close();
    }
}