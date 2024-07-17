package org.example;

import java.util.function.Predicate;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    private static final String NAME_PATTERN = "^[A-Z][a-zA-Z]{2,}$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9.%+-]+\\.[a-zA-Z0-9.%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}(\\.[a-zA-Z]{2,6})?$";
    private static final String PHONE_PATTERN = "^\\d{2} \\d{10}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*\\d)(?=^[^!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/`~]*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/`~][^!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/`~]*$).{8,}$";


    public static boolean validate(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    public static boolean fNameValidate(String fName) throws CustomException {
        Predicate<String> validateFirstName = name -> validate(name, NAME_PATTERN);
        if (validateFirstName.test(fName))
            return true;
        else
            throw new CustomException("Invalid First Name");

    }

    public static boolean lNameValidate(String lName) throws CustomException {
        Predicate<String> validateFirstName = name -> validate(name, NAME_PATTERN);
        if (validateFirstName.test(lName)) {
            return true;
        } else {
            throw new CustomException("Invalid Last Name");
        }
    }

    public static boolean emailValidate(String email) throws CustomException {
        Predicate<String> validateEmail = e -> validate(e, EMAIL_PATTERN);
        if (validateEmail.test(email)) {
            return true;
        } else {
            throw new CustomException("Invalid Email");
        }
    }

    public static boolean phoneNumberValidate(String phoneNumber) throws CustomException {
        Predicate<String> validatePhone = phone -> validate(phone, PHONE_PATTERN);
        if (validatePhone.test(phoneNumber)) {
            return true;
        } else {
            throw new CustomException("Invalid Phone Number");
        }
    }

    public static boolean passwordValidate(String password) throws CustomException {
        Predicate<String> validatePassword = pass -> validate(pass, PASSWORD_PATTERN);
        if (validatePassword.test(password)) {
            return true;
        } else {
            throw new CustomException("Invalid Password");
        }
    }

    public static void main(String[] args) throws CustomException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first name");
        String fName = sc.next();
        System.out.println(fNameValidate(fName));


        System.out.println("Enter last name");
        String lName = sc.next();
        System.out.println(lNameValidate(lName));


        System.out.println("Enter the number of emails : ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter email-id ");
            String email = sc.next();
            System.out.println(emailValidate(email));
        }

        System.out.println("Enter mobile number with country code, space followed by 10 digit number");
        sc.nextLine();
        String phoneNumber = sc.nextLine();
        System.out.println(phoneNumberValidate(phoneNumber));


        System.out.println("Enter password minimum 8 characters, at least 1 uppercase and 1 number and exactly 1 special character");
        String password = sc.nextLine();
        System.out.println(passwordValidate(password));

    }
}