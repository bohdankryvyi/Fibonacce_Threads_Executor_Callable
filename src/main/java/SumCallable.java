import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class SumCallable implements Callable{
    List inputList;

    public SumCallable(List inputList) {
        this.inputList = inputList;
    }

    //main method for Callable. It returns a sum of list elements via streams
    @Override
    public Integer call() throws Exception {
        return (Integer) inputList.stream().collect(Collectors.summingInt(i-> (int) i));
    }
}
