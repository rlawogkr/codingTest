package baekjoon.twoPointer;
import java.io.*;
import java.util.*;

public class Boj_16472 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        Map<Character, Integer> hashMap = new HashMap<>();

        int l = 0, r = 0;
        int maxLength = 0;
        while(r < s.length()){
            Character rightChar = s.charAt(r);
            hashMap.put(rightChar, hashMap.getOrDefault(rightChar, 0) + 1);


            // left pointer 이동
            while(hashMap.size() > n){
                hashMap.put(s.charAt(l), hashMap.get(s.charAt(l)) - 1);
                if(hashMap.get(s.charAt(l)) == 0){
                    hashMap.remove(s.charAt(l));
                }
                l++;
            }
            maxLength = Math.max(maxLength, r-l+1);
            r++;

        }


        System.out.println(maxLength);
        br.close();
    }
}
