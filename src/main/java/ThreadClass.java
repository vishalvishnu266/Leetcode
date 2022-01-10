import java.util.stream.IntStream;

public class ThreadClass {


    public static boolean threadrun(){

        Runnable func = () ->{
            IntStream.range(1,100).forEach(i -> {
                        System.out.println("in thread"+i);
                    }
                    );
        };

        new Thread(func).start();
        return true;


    }
}
