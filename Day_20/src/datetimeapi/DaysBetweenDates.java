package datetimeapi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DaysBetweenDates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("Enter the first date (YYYY-MM-DD): ");
        String date1Str = scanner.nextLine();
        LocalDate date1 = LocalDate.parse(date1Str, formatter);

        System.out.println("Enter the second date (YYYY-MM-DD): ");
        String date2Str = scanner.nextLine();
        LocalDate date2 = LocalDate.parse(date2Str, formatter);

        long daysBetween = ChronoUnit.DAYS.between(date1, date2);

        System.out.println("Number of days between " + date1Str + " and " + date2Str + ": " + daysBetween);
    }
}

