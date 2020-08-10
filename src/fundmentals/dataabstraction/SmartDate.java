package fundmentals.dataabstraction;

/**
 * @author firepond
 * algs4 exercise 1.2.11
 */

import edu.princeton.cs.algs4.StdOut;

public class SmartDate {

    private static int[] DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private static String[] daysInAWeek = { "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday" };
    private static int baseYear = 2000;
    private static int baseMonth = 1;
    private static int baseDay = 1;

    int day;
    int month;
    int year;

    public static void main(String[] args) {
        SmartDate smartDate = new SmartDate(2020, 1, 31);
        StdOut.println(smartDate.year);
        StdOut.println(smartDate.month);
        StdOut.println(smartDate.day);
        StdOut.println(smartDate.dayOfTheWeek());
    }

    public SmartDate(int year, int month, int day) {
        if (!isValidDate(month, day, year)) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public SmartDate(String date) {
        String[] fields = date.split("/");
        int month = Integer.parseInt(fields[0]);
        int day = Integer.parseInt(fields[1]);
        int year = Integer.parseInt(fields[2]);
        if (!isValidDate(month, day, year)) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int day() {
        return day;
    }

    public int month() {
        return month;
    }

    public int year() {
        return year;
    }

    public String toString() {
        return month() + "/" + day() + "/" + year();
    }

    public String dayOfTheWeek() {
        // 2000 01 01 Saturday
        int pastDay = 0;

        for (int currentYear = baseYear; currentYear < year; currentYear++) {
            if (isLeapYear(currentYear)) {
                pastDay += 366;
            } else {
                pastDay += 365;
            }
        }

        for (int currentMonth = baseMonth; currentMonth < month; currentMonth++) {
            if (currentMonth == 2) {
                if (isLeapYear(year)) {
                    pastDay += 29;
                } else {
                    pastDay += 28;
                }
            } else {
                pastDay += DAYS[month];
            }
        }

        pastDay = pastDay + day - baseDay;
        StdOut.println(pastDay);
        return daysInAWeek[pastDay % 7];
    }

    // is the given date valid?
    private static boolean isValidDate(int m, int d, int y) {
        if (m < 1 || m > 12)
            return false;
        if (d < 1 || d > DAYS[m])
            return false;
        if (m == 2 && d == 29 && !isLeapYear(y))
            return false;
        return true;
    }

    // is y a leap year?
    private static boolean isLeapYear(int y) {
        if (y % 400 == 0)
            return true;
        if (y % 100 == 0)
            return false;
        return y % 4 == 0;
    }
}
