package sandBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        List<String> arrayList = new ArrayList<>(Arrays.asList(br.readLine().split("")));//처음 문자열

        for(String s: arrayList){
            System.out.println(s);
        }
        br.close();
    }
}
