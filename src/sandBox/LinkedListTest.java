package sandBox;

import java.util.*;
import java.io.*;

public class LinkedListTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Character> list = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            int pointer = 0;

            for(int j = 0;j < input.length();j++){
                char c = input.charAt(j);
                if(c == '<'){
                    if(pointer <= 0)continue;
                    else --pointer;
                }else if(c == '>'){
                    if(pointer < list.size())++pointer;
                }else if(c == '-'){
                    if(!list.isEmpty()){
                       list.remove(pointer-1);
                       pointer--;
                    }
                }else{
                    list.add(pointer, c);
                    ++pointer;
                }
            }

            for(char ch:list){
                sb.append(ch);
            }sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

}
//bap
