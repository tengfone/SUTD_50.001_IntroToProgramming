package com.example.Question1;

//***[QUESTION 1]*********
// ***ATTENTION*****
// >>>>click BUILD, followed by RUN button in Vocareum to execute main()
//CODE IN THIS FILE IS FOR YOUR INFO
//YOU DO NOT NEED TO EDIT THIS FILE

public class TestSquare {
    public static void main(String[] args) {

        Square a = new Square(0,0,4);
        System.out.println(a.getPerimeter());
        System.out.println(a.contains(1, 1));
        System.out.println(a.contains(-3, 1));
        System.out.println(a.contains( new Square(0.5, -0.5, 2)));
        System.out.println(a.contains( new Square(1.5, 1.5, 2)));


        /*
result:

16.0
true
false
true
false
         */

    }
}