import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class Fibonacci extends Thread {

    private static Object sync = new Object(); //monitor

    List<Integer> inputList  = new ArrayList<Integer>();

    public  void run() {

        //we use synchronized with object to run threads one by one to see correct output
        synchronized (sync) {
            int i = 1, t1 = 0, t2 = 1;
            int n = 10;

            //thread name
            System.out.println(Thread.currentThread().getName());

            // calculate Fibonacci
            while (i <= n) {
                System.out.print(t1 + "  ");
                inputList.add(t1);

                int sum = t1 + t2;
                t1 = t2;
                t2 = sum;

                i++;
            }
            System.out.println("\n");
            super.run();
        }
    }
}
