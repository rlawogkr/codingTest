package sandBox;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        for (int testCase = 0; testCase < t; testCase++) {
            int n = Integer.parseInt(br.readLine()); // 최정예 요원의 수
            int[][] abilities = new int[n][3]; // 요원들의 능력치 배열

            // 각 요원의 능력치 입력 받기
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    abilities[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 갤럭시를 가동할 수 있는지 확인하고 최소 소멸 능력치 출력
            int result = calculateMinimumDestroyedAbilities(abilities);
            sb.append(result).append("\n");
        }

        System.out.print(sb.toString());
        br.close();
    }

    // 갤럭시를 가동할 수 있는지 확인하고 최소 소멸 능력치를 계산하는 함수
    private static int calculateMinimumDestroyedAbilities(int[][] abilities) {
        int minDestroyedAbilities = Integer.MAX_VALUE;

        for (int sharedAbility = 0; sharedAbility < 3; sharedAbility++) {
            int[] destroyedAbilities = new int[abilities.length];

            // 각 요원이 해당 능력치를 선택하여 소멸되는 능력치 계산
            for (int i = 0; i < abilities.length; i++) {
                int remainingAbilities = 0;
                for (int j = 0; j < 3; j++) {
                    if (j != sharedAbility) {
                        remainingAbilities += abilities[i][j];
                    }
                }
                destroyedAbilities[i] = remainingAbilities;
            }

            // 배열을 오름차순으로 정렬하여 최소 소멸 능력치 계산
            Arrays.sort(destroyedAbilities);
            int totalDestroyedAbilities = 0;
            for (int i = 0; i < abilities.length - 1; i++) {
                totalDestroyedAbilities += destroyedAbilities[i];
            }

            // 갤럭시를 가동할 수 있는 경우 최소 소멸 능력치 업데이트
            if (destroyedAbilities[abilities.length - 1] >= 1 && totalDestroyedAbilities < minDestroyedAbilities) {
                minDestroyedAbilities = totalDestroyedAbilities;
            }
        }

        // 갤럭시를 가동할 수 없는 경우 -1 반환
        if (minDestroyedAbilities == Integer.MAX_VALUE) {
            return -1;
        }

        return minDestroyedAbilities;
    }
}