package progammers.hash;

import java.util.*;

public class 영어끝말잇기 {
    public static int[] solution(int n, String[] words){
        Map<Integer, ArrayList<String>> hm = new HashMap<>();
        Set<String> set = new HashSet<>(); // 이전 값들을 넣을 set

        hm.put(1, new ArrayList<>());
        hm.get(1).add(words[0]);
        set.add(words[0]);

        for(int i = 1; i< words.length; i++){
            int personNum = (i%n) + 1; // 해당하는 사람
            if((words[i-1].charAt(words[i-1].length() -1) != words[i].charAt(0)) || set.contains(words[i])){
                return new int[]{personNum, hm.getOrDefault(personNum, new ArrayList<>()).size() + 1};
            }
            hm.putIfAbsent(personNum, new ArrayList<>()); // personNum에 해당하는 key가 없을 경우 초기화
            hm.get(personNum).add(words[i]);
            set.add(words[i]);

        }



        return new int[]{0,0};
    }

    public static void main(String[] args) {
        String[] str= new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] solution = solution(3, str);
        for (int i : solution) {
            System.out.print(i + " ");
        }

    }
}
