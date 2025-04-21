package baekjoon.greedy;
import java.util.*;
import java.io.*;

public class Boj_2138 {
    static int[] toIntArray(String s){
        int[] arr = new int[s.length()];
        for(int i = 0; i<arr.length; i++){
            arr[i] = s.charAt(i)-'0';
        }
        return arr;
    }

    static void change(int idx, int[] arr){
        if(idx - 1 >= 0) arr[idx -1] ^= 1;
        arr[idx] ^= 1;
        if(idx + 1 <= arr.length -1) arr[idx + 1] ^= 1;
    }

    static int pushSwitch(boolean flag, int[] before, int[] after){
        int cnt = 0;
        int[] copyArr = Arrays.copyOf(before, before.length);
        if(flag){
            change(0, copyArr);
            cnt++;
        }

        for(int i = 1; i<= before.length -1 ; i++){
            if(copyArr[i-1] != after[i-1]){
                change(i, copyArr);
                cnt++;
            }
        }
        if(copyArr[copyArr.length-1] != after[after.length -1]){
            return -1;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] before = toIntArray(br.readLine());
        int[] after = toIntArray(br.readLine());

        int caseA = pushSwitch(true, before, after);
        int caseB = pushSwitch(false, before, after);

        if(caseA == -1 && caseB == -1){
            System.out.println(-1);
        }else if(caseA == -1 && caseB > 0){
            System.out.println(caseB);
        }else if(caseA > 0 && caseB == -1){
            System.out.println(caseA);
        }else{
            System.out.println(Math.min(caseA, caseB));
        }

        br.close();
    }
}
