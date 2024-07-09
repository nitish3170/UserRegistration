package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first name");
        String fName=sc.next();
        String pattern = "^[A-Z][a-zA-Z]{2,}$";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(fName);
        if(matcher.matches())
            System.out.println("VALID");
        else
            System.out.println("INVALID");

        System.out.println("Enter last name");
        String lName=sc.next();
        Matcher matcher2 = compiledPattern.matcher(lName);
        if(matcher2.matches())
            System.out.println("VALID");
        else
            System.out.println("INVALID");

        System.out.println("Enter email-id ");
        String email=sc.next();
        String pattern2 = "^[a-zA-Z0-9.%+-]+\\.[a-zA-Z0-9.%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}(\\.[a-zA-Z]{2,6})?$";
        Pattern compiledPattern2 = Pattern.compile(pattern2);
        Matcher matcher3 = compiledPattern2.matcher(email);
        if(matcher3.matches())
            System.out.println("VALID");
        else
            System.out.println("INVALID");

    }
}