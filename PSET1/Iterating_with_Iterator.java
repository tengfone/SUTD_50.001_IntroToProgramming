import java.util.*;

public class IteratingExamples {

    public static int Act2Iterator(List<Integer> integers) {
        int sum = 0;
        
        // Insert code here to sum up input using an Iterator ...
        int i = 0;
        while(i<integers.size()){
            sum += integers.get(i);
            i++;
        }
        return sum;
    }
}
