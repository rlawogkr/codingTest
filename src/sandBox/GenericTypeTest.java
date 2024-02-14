package sandBox;
public class GenericTypeTest {
    static class Sample<T extends Number>{
        T data;

        public void setData(T data){
            this.data = data;
        }
        public T getData(){
            return data;
        }

        public static <T,S,U,V> void test(T x,S y, U z, V a){
            StringBuilder sb = new StringBuilder();
            sb.append(x).append(" ").append(y).append(" ").append(z).append(" ").append(a);
            System.out.println(sb);
        }

    }

    public static void main(String[] args){
        Sample<Integer> a = new Sample<>();
        a.setData(1);
        System.out.println(a.getData());

        Sample<Double> b = new Sample<>();
        b.setData(1.1);
        System.out.println(b.getData());

        Sample.test( a.getData(), b.getData(), "Hello", 'J');


    }
}
