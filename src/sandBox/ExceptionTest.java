package sandBox;

import java.util.EmptyStackException;
import java.util.Stack;

public class ExceptionTest {
    public static void main(String[] args) {
        InnerTest it = new ExceptionTest().new InnerTest();
        try {
            it.add1("1", "r");
        } catch (Exception e) {
            System.out.println("Exception add1");
        }

        try {
            it.add2("1", "r");
        } catch (NumberFormatException e) {
            System.out.println("Exception add2");
        }

        it.emptyStackA();




    }

    class InnerTest {
        void add1(String a, String b) throws Exception {
            int c = Integer.parseInt(a);
            int d = Integer.parseInt(b);
            System.out.println(c + d);
        }

        void add2(String a, String b) throws NumberFormatException {
            int c = Integer.parseInt(a);
            int d = Integer.parseInt(b);
            System.out.println(c + d);
        }
        //내부에서 처리
        void emptyStackA(){
            Stack<Integer> stack = new Stack<>();
            if(!stack.isEmpty()){
                try {
                    throw new EmptyStackAException();
                } catch (EmptyStackAException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        void emptyStackB() throws EmptyStackAException {
            Stack<Integer> stack = new Stack<>();
            if(!stack.isEmpty()){
                throw new EmptyStackAException();
            }
        }

    }

}
