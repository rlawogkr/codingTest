package krafton;
import java.util.*;

public class Test1 {

    public static int solution(int a, int b, int c, int d){
        int[] digit = {a,b,c,d}; // 가능한 모든 숫자 조합 생성
        Set<String> possibleItems = new HashSet<>();

        permute(digit, 0, possibleItems);

        return possibleItems.size();
    }

    // 모든 순열 생성
    private static void permute(int[] digits, int idx, Set<String> possibleTimes){

        // 종료 조건일 때
        if(idx == digits.length){
            int hours = digits[0]*10 + digits[1];
            int minutes = digits[2]*10 + digits[3];

            // 유효한 시간인지 확인
            if(0<= hours && hours < 24 && 0 <= minutes && minutes < 60){
                possibleTimes.add(String.format("%02d:%02d", hours, minutes));
            }
            return;
        }
        for(int i = idx; i< digits.length; i++){
            swap(digits, idx, i);
            permute(digits, idx+1, possibleTimes);
            swap(digits, idx, i); // swap했던 것 원상 복구
        }
    }

    // 배열 arr의 인덱스 i와 인덱스 j 위치 변경
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(solution(1,8,3,2));
        System.out.println(solution(2,3,3,2));
        System.out.println(solution(6,2,4,7));
    }
}
