package com.atos.library.util;

import com.atos.library.configuration.Messages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ScannerUtil {

    public static String askForString(String mes) {
        System.out.println(mes + ":");
        String result = new Scanner(System.in).nextLine().trim();
        if (result == null || result.isEmpty()) {
            System.out.println(mes + Messages.invalidInput);
        }
        return result;
    }

    public static Integer askForInteger(String mes) {
        try {
            System.out.println(mes + ":");
            return new Scanner(System.in).nextInt();
        } catch (Exception ex) {
            System.out.println(mes + Messages.invalidInput);
        }
        return null;
    }

    public static Date askForDate(String mes) {
        String dateString = askForString(mes + "," + Messages.validDateFormat);
        try {
            if(dateString.isEmpty()) return null;
            return new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
        }catch (Exception ex){
            System.out.println(mes + Messages.invalidInput);
        }
        return null;
    }
}
