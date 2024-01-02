package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//이진탐색: 이미 값이 정렬되어 있어야 한다.
//큰 탐색범위를 보면 이진 탐색을 떠올리는 것이 좋음.
public class 가장긴증가하는부분수열2_12015 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] nums = new int[len];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int i = 0;
        while (st.hasMoreTokens()) {
            nums[i++] = Integer.parseInt(st.nextToken());
        }

        int[] clone = nums.clone();
        Arrays.sort(clone);//복제한 값 정렬. 10 10 20 20 30 50

        br.close();
    }
    /*
    nums[] = 1 5 4 1 2
    1 1 2 4 5
    가장 긴 증가하는 부분 수열 구하기. 길이를 return.

     */
    static int binarySearch(int len, int[] nums){
        int mid = len/2;
        int count = 0;

        //왼쪽과 오른쪽 증가하는 수열 개수 count.
        //left: 0 ~ len/2 -> 여기서 다시 binarySearch.
        //right: len/2 + 1 ~ len - 1 -> 여기서 다시 binarySearch.

        //만약 left의 최대값이 right
        return 0;
    }

}
