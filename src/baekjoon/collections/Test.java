package baekjoon.collections;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>((i1, i2)->{
            if(i1 != i2)
                return i2.compareTo(i1);
            else return 0;
        });

        ts.add(50);
        ts.add(10);
        ts.add(30);
        ts.add(20);

        System.out.println(ts.first());   // 10
        System.out.println(ts.last());    // 50
        System.out.println(ts.higher(20)); // 30
        System.out.println(ts.lower(20));  // 10

        // 구간 조회: [10,30)
        for (int x : ts.headSet(30)) {
            System.out.print(x + " ");    // 10 20
        }
        System.out.println();

        // 전체 오름차순 순회
        for (int x : ts) {
            System.out.print(x + " ");    // 10 20 30 50
        }
    }
}
