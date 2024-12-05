package baekjoon.twoPointer;
import java.io.*;
import java.util.*;

public class Boj_16472 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int left = 0;
        int right = 0;
        int maxLength = 0; // 결과값
        Map<Character, Integer> hashMap = new HashMap<>();
        while (right < s.length()) {
            // 오른쪽 포인터로 새로운 문자 추가
            char rightChar = s.charAt(right);
            hashMap.put(rightChar, hashMap.getOrDefault(rightChar, 0) + 1);
            right++;

            // 유효한 알파벳 수가 n을 초과하면 왼쪽 포인터 이동
            while (hashMap.size() > n) {
                char leftChar = s.charAt(left);
                hashMap.put(leftChar, hashMap.get(leftChar) - 1);
                if (hashMap.get(leftChar) == 0) {
                    hashMap.remove(leftChar);
                }
                left++;
            }

            // 최대 길이 갱신
            maxLength = Math.max(maxLength, right - left);
        }

        System.out.println(maxLength);
        br.close();
    }
}
