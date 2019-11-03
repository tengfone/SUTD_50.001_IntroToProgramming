public class Palindrome {
    public static boolean isPalindrome (char[] S) {
                String str = new String(S);
        if (str.length() == 1 || str.length() == 0)
            return true;
        if (str.charAt(0) == str.charAt(str.length() - 1))
            return isPalindrome(str.substring(1, str.length() - 1).toCharArray());
        return false;
    }
}


// Same Like HackerRank

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        if (isPalindrome(A))
            System.out.println("Yes");
        else System.out.println("No");
    }

    public static boolean isPalindrome (String str){
        if(str.length() == 1 || str.length() == 0)
            return true;
        if(str.charAt(0) == str.charAt(str.length() - 1))
            return isPalindrome(str.substring(1,str.length()-1));
        return false;
        }
}
