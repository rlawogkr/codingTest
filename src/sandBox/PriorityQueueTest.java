package sandBox;

import java.util.*;
public class PriorityQueueTest {

    static class Student{
        int mathScore;
        int engScore;
        public Student(int mathScore, int engScore){
            this.mathScore = mathScore;
            this.engScore = engScore;
        }
    }
     static class StuComparator implements Comparator<Student>{
        @Override//오름차순 정렬.
        public int compare(Student o1, Student o2){
            if(o1.mathScore == o2.mathScore)return o1.engScore-o2.engScore;
            else return o1.mathScore - o2.mathScore;
        }
    }
    public static void main(String[] args){
//        PriorityQueue<Student> pq = new PriorityQueue<>(new StuComparator());
        PriorityQueue<Student> pq = new PriorityQueue<>(new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2){
                if(o1.mathScore == o2.mathScore)return o1.engScore-o2.engScore;
                else return o1.mathScore - o2.mathScore;
            }
        });
        pq.offer(new Student(70,50));
        pq.offer(new Student(60,20));
        pq.offer(new Student(60,30));

        while(!pq.isEmpty()){
            Student s = pq.poll();
            System.out.println(s.mathScore + " " + s.engScore);
        }
    }
}
