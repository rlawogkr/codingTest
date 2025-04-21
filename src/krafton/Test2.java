package krafton;

import java.util.*;

public class Test2 {
    private static int solution(int[] a){
        // 전체 칼럼 수
        int n = a.length;

        int maxSizeSide = 0;

        for(int i = 0; i < n;i++){
            int curSide = Math.min(a[i], n-i); // 현재 칼럼에서 만들 수 있는 정사각형 변의 길이

            // 최대값 갱신
            maxSizeSide = Math.max(maxSizeSide, curSide);
        }

        return maxSizeSide;
    }
    public static void main(String[] args) {
        int[] a1 = new int[]{1,2,2,2,4,4,5}; // 3
        int[] a2 = new int[]{1,2,2,4,5}; // 2
        int[] a3 = new int[]{10,10,10,10}; // 4

        System.out.println(solution(a1));
        System.out.println(solution(a2));
        System.out.println(solution(a3));

    }
}
