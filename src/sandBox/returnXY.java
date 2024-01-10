package sandBox;

import java.io.*;
import java.util.*;

/*
[0][0]:1
[1][0]:2 [1][1]:3
[2][0]:4 [2][1]:5  [2][2]:6
[3][0]:7 [3][1]:8 [3][2]:9 [3][3]:10
[4][0]:11 [4][1]:12 [4][2]:13 [4][3]:14 [4][4]:15

(n+1)*(n+2)/2 : 마지막 값. n은 x의 값.
 */
public class returnXY {
    static int startX, startY;
    static int endX, endY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        startX = returnX(target);
        startY = target - startX*(startX+1)/2 - 1;
        System.out.println("startX = " + startX+", startY = " + startY);
        br.close();
    }

    static int returnX(int target){
        int x = 0;
        while(!(target <= (x+1)*(x+2)/2)){
            x++;
        }
        return x;
    }

}