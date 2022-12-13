package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;


public class RandomUtils {

    public static void main(String[] args) {

        RandomUtils randomUtils = new RandomUtils();

        System.out.println(randomUtils.randomString(10));
        System.out.println(actualTimeStampEmail(2));
        System.out.println(randomEmail2(10));
        System.out.println(randomLong(10));
        System.out.println(randomLongRange(1985L, 2023L));
        System.out.println(randomPhone("+7", 10));
        System.out.println(generatedString);
        System.out.println(randomMonth());
        System.out.println(randomDayOfWeek());
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now() + " " + LocalDate.now());
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, d MMMM")));
        System.out.println(randomDate85to23y());
    }

    public static String randomString(int len) {
        String generatedString = RandomStringUtils.randomAlphabetic(len);
        return generatedString;
    }

    public static String actualTimeStampEmail(int len) {
        String generatedString = RandomStringUtils.randomAlphabetic(len).toLowerCase();
        return "test_mail_" + LocalDate.now() + "_" + LocalTime.now().format(DateTimeFormatter.ofPattern("HH_mm")) + generatedString + "@some.com";
    }

    static String randomString2(int len) {
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString() + "!";
    }

    public static String randomEmail2(int len) {// to lower case
        return randomString2(len).toLowerCase() + "@some.com";
    }

    static Long randomLong(int lenArg) {
        final String AB = "0123456789";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(lenArg);
        for (int i = 0; i < lenArg; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return Long.parseLong(sb.toString());
    }

    public static Long randomLongRange(Long minArg, Long maxArg) {
        return ThreadLocalRandom.current().nextLong(minArg, maxArg + 1); // return (long) (Math.random() * (max - min + 1) + min);
    }

    public static String randomPhone(String countryCode, int lenArg) {
        return countryCode + randomLong(lenArg);
    }

    static String generatedString = RandomStringUtils.random(20, true, true);

    public static String randomMonth() {
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int randomMonth = (int) (Math.random() * month.length);
        return month[randomMonth];
    }

    public static String randomDayOfWeek() {
        String[] weekDay = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int randomDayOfWeek = (int) (Math.random() * weekDay.length);
        return weekDay[randomDayOfWeek].toString();
    }

    public static String getActualDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        return localDate.format(formatter);
    }

    public static String getActualTime() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return localTime.format(formatter);
    }

    public static String getActualDayOfWeekAndMonth() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM");

        return localDate.format(formatter);
    }

    /* public static String getActualDateTime(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm");
        return localDate.format(formatter) + " " + localTime.format(formatter);
    }*/

    public static String randomDate85to23y() {
        LocalDate localDate = LocalDate.of(Math.toIntExact((Long) randomLongRange(1985L, 2023L)), Math.toIntExact((Long) randomLongRange(1L, 12L)), Math.toIntExact((Long) randomLongRange(1L, 28L)));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        return localDate.format(formatter);
    }

   /* public static String getFirstName(){
        Faker faker = new Faker();
        return faker.name().firstName();
    }*/

    /**regex examples
     *  System.out.println(generatedString.matches("[a-zA-Z]+"));
     System.out.println(generatedString.matches("[a-z]+"));
     System.out.println(randomLong(10000L).replaceAll("(\\d{3})(?=\\d)", "$1 "));
     System.out.println(randomLong(10000L, 1000000l).replaceAll("(\\d{3})(?=\\d)", "$1 ").replaceAll(" ", "-"));*/

}



