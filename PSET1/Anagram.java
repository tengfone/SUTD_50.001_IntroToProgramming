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

// method 2
    public static boolean isAnagram(String a, String b) {
        a = a.toUpperCase();
        b = b.toUpperCase();
        boolean output = false;
        StringBuilder c = new StringBuilder(b);

        if (a.length() == b.length()) {
            for (int i = 0; i < a.length(); i++) {
                for (int j = 0; j < c.length(); j++) {
                    if (a.charAt(i) == c.charAt(j)) {
                        c.deleteCharAt(j);
                        if (i == a.length() - 1 && c.length() == 0) {
                            output = true;
                            break;
                        }
                        break;
                    }
                }
            }
        }
        return output;

    }
