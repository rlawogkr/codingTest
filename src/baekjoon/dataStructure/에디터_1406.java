package baekjoon.implementation;

import java.io.*;
import java.util.*;

/*
영어 소문자만을 기록할 수 있음.
명령어 수행 전에 커서는 문장의 맨 뒤에 위치.

문자열 길이: N.
둘째 줄: 입력할 명령어의 개수를 나타내는 정수 M(1 ≤ M ≤ 500,000)
M개의 줄: 에디터의 명령어
 */
// 스택 2개로 구현하면 시간초과 문제 해결 가능. Left stack(cursor 왼쪽), Right stack(cursor 오른쪽)
public class 에디터_1406 {
    static int cursor = 0;//cursor 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

//        List<String> list = new LinkedList<>(Arrays.asList(br.readLine().split("")));//처음 문자열. 연결리스트로 구현.

        Stack<String> leftStack = new Stack<>();//처음 문자열. 스택으로 구현
        Stack<String> rightStack = new Stack<>();

        String[] input = br.readLine().split("");
        for (String s : input) {
            leftStack.push(s);
        }

//        cursor = list.size();//커서 위치
        cursor = leftStack.size();//커서 위치
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "L"://커서를 왼쪽으로 한 칸 옮김. 커서가 문장의 맨 앞이면 무시됨.
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                        cursor--;
                    }
                    break;
//                    if (cursor != 0) cursor--;
//                    break;
                case "D"://커서를 오른쪽으로 한 칸 옮김. 커서가 문장의 맨 뒤이면 무시됨.
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                        cursor++;
                    }
                    break;
//                    if (cursor != list.size()) cursor++;
//                    break;
                case "B":
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                        cursor--;
                    }
                    break;
//                    if (cursor != 0) {
//                        list.remove(cursor - 1);
//                        cursor--;
//                    }
//                    break;
                case "P":
                    leftStack.push(command[1]);
                    cursor++;
                    break;
//                    list.add(cursor, command[1]);
//                    cursor++;
//                    break;
            }
        }
//        bw.write(String.join("", list));//String.join()을 사용하면 list의 모든 요소를 하나의 문자열로 합칠 수 있음.
//        bw.flush();
        StringBuilder sb = new StringBuilder();
        while(!leftStack.isEmpty()){
            rightStack.push(leftStack.pop());
        }
        while(!rightStack.isEmpty()){
            sb.append(rightStack.pop());
        }
        System.out.println(sb);
        br.close();
//        bw.close();
    }

}
