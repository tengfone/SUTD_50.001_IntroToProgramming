package com.example.q3;

//***[QUESTION 3]*********

public class SecureClass {

    private static String passwd= "iHateJava";

    public static String getPasswd() {
        return passwd;
    }

    @Override
    public String toString(){
        return "I am an instance of SecureClass";
    }

    //TODO: finish the code for SecureClass
    public static SecureClass requestInstance(String passwdln){
        SecureClass output = new SecureClass();
        if(passwdln == getPasswd()) return output;
        else return null;
    }

}