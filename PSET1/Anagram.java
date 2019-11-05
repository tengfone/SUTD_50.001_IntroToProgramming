// "abc" and "cba" anagram
// "ab1" and "ab2" not anagram

public class MyClass {
    public static void main(String[] args) {
        boolean output;
        output = isAnagram("123","312");
        System.out.println(output);
    }

    public static boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length())
            return false;
        char[] ss1 = s1.toCharArray();
        char [] ss2 = s2.toCharArray();
        Arrays.sort(ss1);
        Arrays.sort(ss2);
        for(int i =0; i < ss1.length; i++){
            if(ss1[i] != ss2[i])
                return false;
        }
        return true;
    }
}
