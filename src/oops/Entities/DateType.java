package oops.Entities;

public class DateType {
    private int year;
    private int month;
    private int day;

    private static final int[] DAYS_IN_MONTH = {31,28,31,30,31,30,31,31,30,31,30,31};

    public DateType(int day , int month , int year){

        if(!isValid(day,month,year)){
            throw new IllegalArgumentException("Invalid date: " + day + "/" + month + "/" + year);
        }
        this.year = year;
        this.day = day;
        this.month = month;
    }

    private static boolean isValid(int day, int month, int year) {
        if (month < 1 || month > 12) return false;
        if (day < 1 || day > daysInMonth(month, year)) return false;
        return true;
    }

    private static int daysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year)) return 29;
        return DAYS_IN_MONTH[month - 1];
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }





}
