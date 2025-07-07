package util;

import java.sql.Date;
import java.util.Scanner;

public class InputUtil {

    private final static Scanner sc = new Scanner(System.in);

    public static String getStringInput(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = sc.nextLine();
            if (input != null && !input.isEmpty()) return input;
            else System.out.println("Please enter a valid input string.");
        }
    }

    public static String getCharacterInput(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = sc.nextLine();
            if (input != null && input.length() == 1) return input.trim().toLowerCase();
            else System.out.println("Please enter a valid input character.");
        }
    }

    public static int getIntegerInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try{
                return Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Invalid input. Enter a valid integer");
            }

        }
    }

    public static Date getDateInput(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = sc.nextLine();
            try {
                return Date.valueOf(input); //date in YYYY-MM-DD format
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid date format. Please enter a date in YYYY-MM-DD format.");
            }
        }
    }

    public static String trimTextInput(String text, int maxLength) {
        if (text.length() <= maxLength) {
            return text;
        } else {
            return text.substring(0, maxLength - 3) + "...";
        }
    }
}
