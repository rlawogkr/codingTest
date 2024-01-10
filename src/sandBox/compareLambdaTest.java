package sandBox;

import java.util.*;

public class compareLambdaTest {
    public static void main(String[] args) {
        int[][] abilities = {{9, 8, 7}, {7, 14, 5}};
        for(int i = 0;i<abilities.length;i++){
            System.out.println(abilities[i][0] + ", " + abilities[i][1] + ", " + abilities[i][2]);
        }
        System.out.println("--------------------");
        Arrays.sort(abilities, (a, b) -> Integer.compare(Math.min(a[0], Math.min(a[1], a[2])),
                Math.min(b[0], Math.min(b[1], b[2]))));//최소값을 기준으로 오름차순으로 정렬.
// 정렬 후
        for(int i = 0;i<abilities.length;i++){
            System.out.println(abilities[i][0] + ", " + abilities[i][1] + ", " + abilities[i][2]);
        }


    }
}
