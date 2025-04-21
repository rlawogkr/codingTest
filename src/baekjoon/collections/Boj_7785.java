package baekjoon.collections;
import java.util.*;
import java.io.*;

public class Boj_7785 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 출입 기록의 수

        Set<String> set = new TreeSet<>((s1, s2)->{
            if(!s1.equals(s2))return s2.compareTo(s1);
            else return 0;
        });
        for(int i = 0; i<n ; i++){
            String[] strs = br.readLine().split(" ");
            if(strs[1].equals("enter")){
                set.add(strs[0]);
            }else{
                set.remove(strs[0]);
            }
        }

        for(String s : set){
            System.out.println(s);
        }
        br.close();
    }
}
