package osScheduler;

import java.util.*;

public class SimpleScheduler {
    private static void print(Map<String, Integer> waiting, Map<String, Integer> turnaround) {
        int sumW = 0, sumT = 0, n = waiting.size();

        // keySet 순회(입력 개수가 적으므로 정렬 없이 바로 출력)
        for (String pid : waiting.keySet()) {
            System.out.printf("%3s | %7d | %10d%n", pid, waiting.get(pid), turnaround.get(pid));
            sumW += waiting.get(pid);
            sumT += turnaround.get(pid);
        }
        System.out.printf("AVG | %7.2f | %10.2f%n%n", (double) sumW / n, (double) sumT / n);
    }

    public static void sjn(List<Process> list) {
        System.out.println("=== SJN 실행 순서 ===");
        List<Process> processList = new ArrayList<>(list);
        Collections.sort(processList, (p1, p2) -> { // 도착 순서대로 오름차순 정렬
            if (p1.arrival != p2.arrival) return p1.arrival - p2.arrival;
            return 0;
        });

        Map<String, Integer> waiting = new HashMap<>();
        Map<String, Integer> turnaround = new HashMap<>();
        int time = 0;   // 지나간 시간
        while (!processList.isEmpty()) {
            Process nextProcess = null;
            for (Process p : processList) {
                if (p.arrival <= time && (nextProcess == null || p.burst < nextProcess.burst)) nextProcess = p;
            }
            if (nextProcess == null) {
                time++;
                continue;
            }
            System.out.print(nextProcess.pid + " ");
            time += nextProcess.burst; // nextProcess 작업이 끝난 후 시간(즉, 완료시각)
            waiting.put(nextProcess.pid, time - (nextProcess.arrival + nextProcess.burst)); // 얼마나 기다렸는지를 map에 담음
            turnaround.put(nextProcess.pid, time - nextProcess.arrival);   // 프로세스가 도착해서 끝날 때까지 얼마나 걸렸는지를 map에 담음
            processList.remove(nextProcess);    // 해당 프로세스 제거
        }
        System.out.println("\n");
        print(waiting, turnaround);
    }

    public static void prioritySchedule(List<Process> list) {
        System.out.println("=== PrioritySchedule 실행 순서 ===");
        List<Process> processList = new ArrayList<>(list);
        Collections.sort(processList, (p1, p2) -> {
            if (p1.arrival != p2.arrival) return p1.arrival - p2.arrival;
            return 0;
        });

        Map<String, Integer> waiting = new HashMap<>();
        Map<String, Integer> turnaround = new HashMap<>();
        int time = 0;

        while (!processList.isEmpty()) {
            Process nextProcess = null;
            for (Process p : processList) {
                if (p.arrival <= time && (nextProcess == null || p.priority < nextProcess.priority || (p.priority == nextProcess.priority && p.arrival < nextProcess.arrival)))
                    nextProcess = p;
            }
            if (nextProcess == null) {
                time++;
                continue;
            }
            System.out.print(nextProcess.pid + " ");
            time += nextProcess.burst; // nextProcess 작업이 끝난 후 시간(즉, 완료시각)
            waiting.put(nextProcess.pid, time - (nextProcess.arrival + nextProcess.burst)); // 얼마나 기다렸는지를 map에 담음
            turnaround.put(nextProcess.pid, time - nextProcess.arrival);   // 프로세스가 도착해서 끝날 때까지 얼마나 걸렸는지를 map에 담음
            processList.remove(nextProcess);    // 해당 프로세스 제거
        }
        System.out.println("\n");
        print(waiting, turnaround);
    }

    public static void roundRobin(List<Process> list, int TIME_QUANTUM){
        System.out.println("=== RoundRobin 실행 순서 ===");
        Queue<Process> ready = new ArrayDeque<>();  // ready 큐
        List<Process> incoming = new ArrayList<>(list); // 아직 들어오지 않은 프로세스

        Collections.sort(incoming, (p1,p2) -> {
            if(p1.arrival != p2.arrival) return p1.arrival - p2.arrival;
            return 0;
        });

        Map<String, Integer> remainProcess = new HashMap<>(); // PID -> 남은 burst
        Map<String, Integer> waiting = new HashMap<>();
        Map<String, Integer> turnaround = new HashMap<>();
        int time = 0;

        while(!incoming.isEmpty() || !turnaround.isEmpty()){
            Iterator<Process> iter = incoming.iterator();
            while(iter.hasNext()){
                Process p = iter.next();
                if(p.arrival <= time){
                    ready.add(p);   // 만약 조건에 해당될 경우, ready 큐에 넣음
                    remainProcess.put(p.pid, p.burst); // 아직 한 번도 깎이지 않았으므로
                    iter.remove(); // next로 읽어온 객체 삭제
                }
            }
            if(ready.isEmpty()){
                time++;
                continue;
            }
            /* 3) 큐 앞쪽 프로세스 실행 */
            Process cur = ready.poll();
            int slice = Math.min(TIME_QUANTUM, remainProcess.get(cur.pid)); // 실제 실행 시간
            System.out.print(cur.pid + "(" + slice + ") ");
            time += slice;                                   // CPU 사용
            remainProcess.put(cur.pid, remainProcess.get(cur.pid) - slice);

            /* 4) slice 도중 새로 도착한 프로세스 추가 */
            iter = incoming.iterator();
            while (iter.hasNext()) {
                Process p = iter.next();
                if (p.arrival <= time) {
                    ready.add(p);
                    remainProcess.put(p.pid, p.burst);
                    iter.remove();
                }
            }

            /* 5) 현재 프로세스가 끝났는지 확인 */
            if (remainProcess.get(cur.pid) > 0) {
                ready.add(cur);                              // 남았으면 큐 뒤로
            } else {
                /* 완료 시점에 Waiting·Turnaround 계산 */
                waiting.put(cur.pid, time - cur.arrival - cur.burst);
                turnaround.put(cur.pid, time - cur.arrival);
            }
        }
        System.out.println("\n");
        print(waiting, turnaround);
    }

    public static void main(String[] args) {
        List<Process> demo = Arrays.asList(
                new Process("P1", 0, 10, 3),
                new Process("P2", 0, 4, 1),
                new Process("P3", 0, 6, 2)
        );

        sjn(demo);                     // Shortest-Job-Next
        prioritySchedule(demo);        // Priority
        roundRobin(demo, 4);           // RR, time-quantum = 4
    }

}






















