package baekjoon.brutalForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 적어도대부분의배수_1145 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] strings = br.readLine().split(" ");

            int[] nums = new int[5];
            //첫째줄에 5가지 자연수 들어옴.
            for(int i = 0;i<5;i++){
                nums[i] = Integer.parseInt(strings[i]);
            }
            Arrays.sort(nums);//값 정렬.

            int target = nums[0];//가장 작은 값.
            int count = 0;
            while(true){
                count = is_dividable(target, nums);
                if(count > 2)break;//범위 실수.. 3이랑 같을 때가 아니라 3이상일 때를 해야 됌.
                else target++;
            }
            System.out.println(target);
            br.close();
        }
        //target을 나눴을 때, return 값이 몇 개가 나오는지를 return.
        //입력값: 1 2 3 4 5 //결과값: 4
        static int is_dividable(int target, int[] nums){
            int count = 0;
            for(int i = 0;i<nums.length;i++){
                if(target%nums[i] == 0)count++;
            }
            return count;
        }
}
