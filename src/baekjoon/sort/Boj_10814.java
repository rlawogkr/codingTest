package baekjoon.sort;

import java.io.*;
import java.util.*;
public class Boj_10814 {
    static int n;

    static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
        int getAge(){return age;}
        String getName(){return name;}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Person(age, name));
        }
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int ageDiff = o1.getAge() - o2.getAge();
                return ageDiff;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Person person : list) {
            sb.append(person.getAge()).append(" ").append(person.getName()).append("\n");
        }
        System.out.println(sb);

        br.close();
    }
}
