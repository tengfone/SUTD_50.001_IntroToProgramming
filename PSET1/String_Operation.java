import java.util.Arrays;

public class Pset1 {	
	public static boolean isAllCharacterUnique(String sIn) {
        char tempArray[] = sIn.toCharArray();
        Arrays.sort(tempArray);
        for(int i =0;i<tempArray.length-1;i++){
            if(tempArray[i]==tempArray[i+1]){
                return false;
            }
        }
        return true;
    }
	public static boolean isPermutation(String sIn1, String sIn2) {
	  //todo: add your implementation
        char[] array1 = sIn1.toCharArray();
        char[] array2 = sIn2.toCharArray();
      //check if both length same
        if(array1.length != array2.length)
            return false;
      //sort both strings
        Arrays.sort(array1);
        Arrays.sort(array2);
      //compare sorted
        for (int i = 0; i<sIn1.length();i++){
            if(array1[i]!=array2[i])
                return false;
        }
        return true;
	}
}
