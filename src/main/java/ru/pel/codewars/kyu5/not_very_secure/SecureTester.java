package ru.pel.codewars.kyu5.not_very_secure;

public class SecureTester {
    private SecureTester(){/*hides public constructor*/}
    public static boolean alphanumeric(String s){
        return s.matches("^\\p{Alnum}+$");
    }
}
