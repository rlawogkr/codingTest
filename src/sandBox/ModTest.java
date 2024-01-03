package sandBox;

import java.io.*;
import java.util.*;

public class ModTest {
    static int k;
    public static void main(String[] args) throws IOException {
        int a = 10;
        int b = 12;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        Long res = 0L;
        for(int i = 0;i<k;i++){
            res = multiplication(a,i)%b;
            System.out.println("a: " + a + ", i: " + i + ", res: " + res);
        }
        br.close();
    }

    static Long multiplication(int a, int b){
        Long result = 1L;
        for(int i = 0;i<b;i++){
            result *= a;
        }
        return result;
    }
}
