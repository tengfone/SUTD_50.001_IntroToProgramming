import java.util.ArrayList;
public class Permutation {
    private final String in;
    private ArrayList<String> a = new ArrayList<String>();
    // additional attribute if needed



    Permutation(final String str){
        in = str;
        // additional initialization if needed

    }

    public void permute(){
        // produce the permuted sequence of 'in' and store in 'a', recursively
        permute(in,"");
    }
    
    public void permute(String str, String ans){
        int n = str.length();
        if (n==0)
            a.add(ans);
        
        for (int i = 0; i < n; i++){
            char first = str.charAt(i);
            String out = str.substring(0,i) + str.substring(i+1,n);
            permute(out,ans+first);
        }
    }

    public ArrayList<String> getA(){
        return a;
    }
}
