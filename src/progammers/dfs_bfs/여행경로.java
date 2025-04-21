import java.util.List;
import java.util.ArrayList;

public class 여행경로 {
    public static void main(String[] args) {
        // List 생성
        List<String> stringList = new ArrayList<>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");


        // List<String>을 String[]로 변환
        String[] stringArray = stringList.toArray(new String[0]);

        // 결과 출력
        for (String str : stringArray) {
            System.out.println(str);
        }
    }
}
