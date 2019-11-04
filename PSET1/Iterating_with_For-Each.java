import java.util.*;

public class IteratingExamples {

      public static int Act2ForEach(List<Integer> integers) {
        int sum = 0;

        for(int i : integers){
            sum += i;
        }

        return sum;

      }
}
