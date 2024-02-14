package sandBox;

interface MyInterface{
    void method1();
}

/**
 * AnonymousClass: 클래스를 정의하고 동시에 인스턴스를 생성하는 방법.
 * 주로 Interface 나 AbstractClass 의 인스턴스를 만들 때 사용.
 */
public class AnonymousClassTest {
    public static void main(String[] args){
        MyInterface tmp = new MyInterface(){
            @Override
            public void method1(){
                System.out.println("method1() 실행");
            }
        };
        tmp.method1();
    }
}
