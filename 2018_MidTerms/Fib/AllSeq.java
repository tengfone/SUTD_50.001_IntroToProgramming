package com.example.Fib;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//starting code


public class AllSeq {
    public static void main(String[] args) {
        String[] s = {"p", "q"};
        System.out.println(compAllSeq(s, 3));

        String[] s2 = {"1", "2", "3", "4"};
        System.out.println(compAllSeq(s2, 1));
    }


    public static ArrayList<String> compAllSeq(String[] s, int k) {
        ArrayList<String> stringList = new ArrayList<String>(Arrays.asList(s));
        //TODO: implement recursive method to compute all possible sequences of length k
        if(k == 1)
            return stringList;
        // todo: Question 4b and 5
    }
}

