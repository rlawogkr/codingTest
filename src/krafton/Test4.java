package krafton;
import java.util.*;

public class Test4 {
    // T: 스킬트리, A: 원하는 스킬
    public static int solution(int[] T, int[] A){
        // 필요한 스킬을 저장하는 집합
       Set<Integer> set = new HashSet<>();
       for(int i = 0; i<A.length; i++){
           if(!set.contains(A[i])){
               set.add(A[i]);
               int tmp = T[A[i]];
               while(tmp != 0){
                  set.add(tmp);
                  tmp = T[tmp];
               }
               set.add(0);
           }
       }
       return set.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0,0,1,1}, new int[]{2}));
        System.out.println(solution(new int[]{0,0,0,0,2,3,3}, new int[]{2,5,6}));
        System.out.println(solution(new int[]{0,0,1,2}, new int[]{1,2}));
        System.out.println(solution(new int[]{0, 3, 0, 0, 5, 0, 5}, new int[]{4,2,6,1,0}));
    }
}
