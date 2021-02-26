import java.util.Scanner;
import java.util.concurrent.*;

public class main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Run 3 synchronized threads via Thread.start();
        Fibonacci fibonacci = new Fibonacci();
        Fibonacci fibonacci1 = new Fibonacci();
        Fibonacci fibonacci2 = new Fibonacci();
        fibonacci.start();
        fibonacci1.start();
        fibonacci2.start();

        //Other option to run one more thread via Executor interface. Executor is implemented based on ThreadPoolExecutor
        Fibonacci fibonacciExecutor = new Fibonacci();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(fibonacciExecutor);

        //an instance of our task for summing elements in the List
        Callable suma = new SumCallable(fibonacciExecutor.inputList);

        //Future interface that will return a result of task(Callable)
        Future result = executor.submit(suma);

        //Write down a result of summing Fibonacci numbers from ExecutorService thread
        // Task is completed asynchronized via Callable task
        System.out.println("Sum of Fibonacci numbers for pool-1-thread-1 : " + result.get());
    }
}
