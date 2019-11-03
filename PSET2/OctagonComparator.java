import java.util.*;

//Modify the class header to implement the appropriate interface
public class OctagonComparator implements Comparator<Octagon>{ 
    
    //then implement the method(s) in the interface
    @Override
    public int compare(Octagon s1, Octagon s2){
        if (s1.getSide() < s2.getSide())
            return -1;
        if (s1.getSide() == s2.getSide())
            return 0;
        else return 1;
    }
}


