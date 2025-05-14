package osScheduler;

class Process {
    String pid;     // 프로세스 id
    int arrival;    // 도착 시간
    int burst;      // 프로세스 실행시간
    int priority;   // 각 프로세스 우선순위(낮을수록 높음)
    public Process(String pid, int arrival, int burst, int priority){
        this.pid = pid;
        this.arrival = arrival;
        this.burst = burst;
        this.priority = priority;
    }
}
