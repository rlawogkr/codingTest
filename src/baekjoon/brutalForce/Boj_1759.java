package baekjoon.brutalForce;
import java.io.*;
import java.util.*;
//1759. 암호 만들기
//l개의 소문자로 구성. 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성
//오름차순으로 정렬된 암호. 가능성 있는 암호들을 모두 구하는 프로그램
//C개의 문자들 중 L개를 선택하는 모든 조합을 구하고, 그 중 모음과 자음의 개수를 확인
public class Boj_1759 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());//암호의 길이
        int c = Integer.parseInt(st.nextToken());//주어진 문자의 개수
        char[] arr = new char[c];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<c; i++){
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        boolean[] visited = new boolean[c];
        dfs(arr, visited, 0, 0, l, c);

//
        br.close();
    }
    static void dfs(char[] arr, boolean[] visited, int start, int cnt, int l, int c){
        if(cnt == l){
            int moeum = 0, jaeum = 0;//모음, 자음의 개수
            for(int i=0; i<c; i++){
                if(visited[i]){
                    char ch = arr[i];
                    if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') moeum++;
                    else jaeum++;
                    sb.append(ch);
                }
            }
            if(moeum >= 1 && jaeum >= 2) System.out.println(sb);
            sb.setLength(sb.length()-l); //sb 초기화
            return;
        }
        for(int i=start; i<c; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(arr, visited, i+1, cnt+1, l, c);
                visited[i] = false;
            }
        }
    }
}



//  for(int i=0; i<(1<<c); i++){//비트마스킹
//            int cnt = 0;//선택한 문자의 개수
//            for(int j=0; j<c; j++){
//                if((i & (1<<j)) != 0) cnt++;
//            }
//            if(cnt == l){
//                int vowel = 0, consonant = 0;//모음, 자음의 개수
//                for(int j=0; j<c; j++){
//                    if((i & (1<<j)) != 0){
//                        char ch = arr[j];
//                        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') vowel++;
//                        else consonant++;
//                        sb.append(ch);
//                    }
//                }
//                if(vowel >= 1 && consonant >= 2) sb.append("\n");
//                else sb.setLength(sb.length()-l);
//            }
//        }
