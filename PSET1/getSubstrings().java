import java.util.HashMap;
import java.util.Map;

public class WordFinder {
    public static Map<String, Integer> getSubstrings(String haystack, String[] needles) { 
        // TODO: Implement (Problem e)
        HashMap <String,Integer> output = new HashMap<String,Integer>();
        for (int i = 0; i<needles.length;i++){
            int index = haystack.indexOf(needles[i]);
            if (index!= -1)
                output.put(needles[i],index);
        }
        return output;
    }
}
