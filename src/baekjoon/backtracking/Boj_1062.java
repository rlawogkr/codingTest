package baekjoon.backtracking;

import java.io.*;

// 1062. 가르침
public class Boj_1062 {

    static int n, k;
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    static String[] word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        k = Integer.parseInt(strings[1]);

        if(k < 5) { //a c i n t
            System.out.println("0");
            return;
        } else if(k == 26) { //모든 알파벳을 다 읽을 수 있다.
            System.out.println(n);
            return;
        }

        visited = new boolean[26]; //각 알파벳을 배웠는지 체크
        word = new String[n];

        for(int i = 0; i < n; i++) {
            word[i] = br.readLine();
        }
        for(int i = 0; i< 26; i++){
            if(i == 'a' - 'a' || i == 'c' - 'a' || i == 'i' - 'a' || i == 'n' - 'a' || i == 't' - 'a'){
                visited[i] = true;
            }
        }

        backtracking(0, 0);
        System.out.println(max);
        br.close();
    }

    // alpha: 현재 알파벳, len: 배운 알파벳의 개수
    public static void backtracking(int alpha, int len) {
        if(len == k - 5) {
            int count = 0;
            for(int i = 0; i < n; i++) { //뽑은 알파벳으로 몇개의 단어를 읽을 수 있는지 카운트.
                boolean read = true;
                for(int j = 0; j < word[i].length(); j++) {
                    if(!visited[word[i].charAt(j) - 'a']) {
                        read = false;
                        break;
                    }
                }
                if(read) count++;
            }
            max = Math.max(max, count);
            return;
        }

        for(int i = alpha; i < 26; i++) {
            if(!visited[i]) {
                visited[i] = true;
                backtracking(i + 1, len + 1);
                visited[i] = false;
            }
        }
    }
}
