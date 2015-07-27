package com;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Igor on 27.07.2015.
 */
public class Executor {

    private Pattern pattern;

    public Executor() {
    }

    private boolean validate(String hours, String minutes) {
        pattern = Pattern.compile("\\d\\d");
        Matcher matcher = pattern.matcher(hours);
        if (!matcher.matches()) {
            return false;
        }
        matcher = pattern.matcher(minutes);
        if (!matcher.matches()) {
            return false;
        }
        return validateHours(hours) && validateMinutes(minutes);
    }

    private boolean validateHours(String hours) {
        int h = getStringParseInt(hours);
        if (h >= 0 && h <= 23) {
            return true;
        }
        return false;
    }

    private boolean validateMinutes(String minutes) {
        int h = getStringParseInt(minutes);
        if (h >= 0 && h <= 59) {
            return true;
        }
        return false;
    }

    private int getStringParseInt(String hours) {
        return Integer.parseInt(hours.substring(0, 2));
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        do {
            System.out.println("input hours: HH = ");
            String hours = scanner.nextLine();
            System.out.println("input hours: MM = ");
            String minutes = scanner.nextLine();
            if (validate(hours, minutes)) {
                System.out.println(hours + ":" + minutes + "   Angle = " + new Angle(getStringParseInt(hours), getStringParseInt(minutes)).getAngle());
                System.out.println("Do you want to continue? (true/false)");
                flag = scanner.nextBoolean();
                scanner.nextLine();
            }
        } while (flag);
    }

    public static void main(String[] args) {
        new Executor().execute();
    }

}
