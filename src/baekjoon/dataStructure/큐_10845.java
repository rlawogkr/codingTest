package baekjoon.dataStructure;

import java.io.*;
import java.util.*;

public class 큐_10845 {
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());//명령어 개수(1<=N<=10000)

        for(int i = 0;i<N;i++){
            String[] command = br.readLine().split(" ");
            solution(command);
        }

        br.close();

    }
    static void solution(String[] command){
        switch (command[0]) {
            case "push":
                queue.add(Integer.parseInt(command[1]));
                break;
            case "pop":
                if(queue.isEmpty()) System.out.println(-1);
                else System.out.println(queue.poll());
                break;
            case "size":
                System.out.println(queue.size());
                break;
            case "empty":
                if(queue.isEmpty()) System.out.println(1);
                else System.out.println(0);
                break;
            case "front":
                if(queue.isEmpty()) System.out.println(-1);
                else System.out.println(queue.peek());
                break;
            case "back"://rear원소를 출력
                if(queue.isEmpty()) System.out.println(-1);
//                else System.out.println(((LinkedList<Integer>) queue).getLast());
                else{
                    int value = 0;
                    for(int i = 0;i<queue.size();i++){
                        value = queue.poll();
                        queue.offer(value);
                    }
                    System.out.println(value);
                }
                break;

        }
    }
}
