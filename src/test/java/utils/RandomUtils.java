package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static tests.TestData.*;


public class RandomUtils {

    public static void main(String[] args) {

        RandomUtils randomUtils = new RandomUtils();

        System.out.println("randomString " + randomUtils.randomString(10));
        System.out.println("randomString2 " + randomUtils.randomString2(10));
        System.out.println("randomItemFromArrayRange " + randomUtils.randomItemFromArrayRange(0, 4));
        System.out.println("randomItemFromAllArray " + randomItemFromAllArray(someArrayItems));
        System.out.println("actualTimeStampEmail " + randomUtils.actualTimeStampEmail(2));
        System.out.println("randomEmail.toLowerCase() " + randomEmail(10));
        System.out.println("randomEmailRndDomainSetLen " + randomEmailRndDomainSetLen( 6));
        System.out.println("randomIntRange " + randomIntRange(10, 20));
        System.out.println("randomLong " + randomLong(10));
        System.out.println("randomLongRange " + randomLongRange(1985L, 2023L));
        System.out.println(randomLongRange(10000L, 1000000l));
        System.out.println("randomPhone " + randomPhone("+7", 10));
        System.out.println("generatedString " + generatedString);
        System.out.println(randomMonth());
        System.out.println(randomDayOfWeek());
        System.out.println("getActualDate// " + getActualDate());
        System.out.println(LocalDate.now());
        System.out.println("getActualTime " + getActualTime());// similar to LocalDate.now()
        System.out.println(LocalTime.now() + " " + LocalDate.now());
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, d MMMM")));
        System.out.println(randomDate85to23y());
        System.out.println("randomDob " + randomDob());
        System.out.println("randomDobDay " + randomDobDay());
        System.out.println("randomDobMonth " + randomDobMonth());
        System.out.println("randomDobYear " + randomDobYear());
        System.out.println(("randomSubject  " + randomSubject()));
        System.out.println(("randomSubjectArray " + randomSubjectArray()));
        System.out.println(("randomSubjectSet " + randomSubjectSet()));
        System.out.println(("randomSubjectMap " + randomSubjectMap()));
    }

    public static String randomString(int len) {
        String generatedString = RandomStringUtils.randomAlphabetic(len);
        return generatedString;
    }

    static String randomString2(int len) {
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString() + "_some_text";
    }

    static String generatedString = RandomStringUtils.random(20, true, true);

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

    public static int randomIntRange (int min, int max) {
       // return ThreadLocalRandom.current().nextInt(min, max + 1); // Java ThreadLocalRandom
        Random random = new Random(); //java.util.Random
        return random.nextInt(max - min + 1) + min;
    }

    public static String[] someArrayItems = {"a","b","c","d","e"};
    public static String randomItemFromArrayRange (int min, int max){
        int randomIndex = (int) (Math.random() * (max - min + 1) + min);
        return someArrayItems[randomIndex];
    }

    /*public static String randomItemFromAllArrayOLD (String[] arrayNameArg) {
        int randomIndex = randomIntRange(0, arrayNameArg.length ); // error ArrayIndexOutOfBoundsException,  try to set - 1
        return arrayNameArg[randomIndex];
    } */
    public static String randomItemFromAllArray (String[] arrayNameArg) {
        int randomIndex = (int) (Math.random() * (arrayNameArg.length )); // (int) (Math.random() * (arrayNameArg.length - 1));
        return arrayNameArg[randomIndex];
    }

    public static String randomEmail(int len) {// to lower case
        return randomString2(len).toLowerCase() + "@some.com";
    }

    public static String randomEmailRndDomainSetLen (int lenArg){
        int randomIndex = randomIntRange(0, randomDomainArray.length );
        return "test_mail_" + LocalDate.now() + "_" + LocalTime.now().format(DateTimeFormatter.ofPattern("HH_mm")) + randomString(lenArg).toLowerCase() + "@" + randomDomainArray[randomIndex];
    }

    public static String actualTimeStampEmail(int len) {
        String generatedString = RandomStringUtils.randomAlphabetic(len).toLowerCase();
        return "test_mail_" + LocalDate.now() + "_" + LocalTime.now().format(DateTimeFormatter.ofPattern("HH_mm")) + generatedString + "@some.com";
    }


    public static String randomPhone(String countryCode, int lenArg) {
        return countryCode + randomLong(lenArg).toString();  //why  not toString()
    }


    public static String randomMonth() {
        int randomMonth = (int) (Math.random() * month.length);
        return month[randomMonth].toString();
    }

    public static String randomDayOfWeek() {
        String[] weekDay = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int randomDayOfWeek = (int) (Math.random() * weekDay.length);
        return weekDay[randomDayOfWeek].toString();
    }

    public static String getActualDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMMM/yyyy");
        return localDate.format(formatter);
    }

    public static String getActualTime() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH_mm"); //("HH:mm"), ("HH:mm:ss"), ("HH:mm:ss.SSS"), ("HH:mm:ss.SSSSSS"), ("HH:mm:ss.SSSSSSSSS")
        return localTime.format(formatter);
    }

    public static String randomDob() {
        LocalDate localDate = LocalDate.now(); // ("dd/MM/yyyy")
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMMM/yyyy").withLocale(Locale.ENGLISH);  //https://stackoverflow.com/questions/51843760/how-can-i-change-the-language-of-the-months-provided-by-localdate
        int randomYear = (int) (Math.random() * (localDate.getYear() - 1950 + 1) + 1950);
        int randomMonth = (int) (Math.random() * 12 + 1);
        int randomDay = (int) (Math.random() * 28 + 1);
        return LocalDate.of(randomYear, randomMonth, randomDay).format(formatter).toString();
    }

    public static String randomDobDay() {
        String[] dob = randomDob().split("/");
        return dob[0];
    }
    public static String randomDobMonth() {
        String[] dob = randomDob().split("/");
        return dob[1];
    }
    public static String randomDobYear() {
        String[] dob = randomDob().split("/");
        return dob[2];
    }

   /* public static String randomDobYear2(int minYear) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMMM/yyyy").withLocale(Locale.ENGLISH);
        int randomYear = (int) (Math.random() * (localDate.getYear() - minYear + 1) + minYear);
        int randomMonth = (int) (Math.random() * 12 + 1);
        int randomDay = (int) (Math.random() * 28 + 1);
        return LocalDate.of(randomYear, randomMonth, randomDay).format(formatter).toString();
    }
    public static String randomDobYear2() {
        String[] dob = randomDob().split("/");
        return dob[2];
    }*/


    public static String getActualDayOfWeekAndMonth() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM");
        return localDate.format(formatter);
    }

    public static String randomDate85to23y() {
        LocalDate localDate = LocalDate.of(Math.toIntExact((Long) randomLongRange(1985L, 2023L)), Math.toIntExact((Long) randomLongRange(1L, 12L)), Math.toIntExact((Long) randomLongRange(1L, 28L)));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        return localDate.format(formatter);
    }

   /* public static String getFirstName(){
        Faker faker = new Faker();
        return faker.name().firstName();
    }*/

    /* examples of using List, Set, Map, HashMap */

    public static String randomSubject() {
        int randomSubject = (int) (Math.random() * userSubjects.size());
        return userSubjects.get(randomSubject).toString();
    }

    public static String randomSubjectArray() {
        int randomSubject = (int) (Math.random() * userSubjectsArray.length);
        return userSubjectsArray[randomSubject];
    }

    public static String randomSubjectSet() {
        Set<String> userSubjectsSet = new HashSet<>(Arrays.asList(userSubjectsArray));
        int randomSubject = (int) (Math.random() * userSubjectsSet.size());
        return userSubjectsSet.toArray()[randomSubject].toString();
    }

    public static String randomSubjectMap() {
        Map<Integer, String> userSubjectsMap = new HashMap<>();
        for (int i = 0; i < userSubjectsArray.length; i++) {
            userSubjectsMap.put(i, userSubjectsArray[i]);
        }
        int randomSubject = (int) (Math.random() * userSubjectsMap.size());
        return userSubjectsMap.get(randomSubject);
    }

    /**regex examples
     *  System.out.println(generatedString.matches("[a-zA-Z]+"));
     System.out.println(generatedString.matches("[a-z]+"));
     System.out.println(randomLong(10000L).replaceAll("(\\d{3})(?=\\d)", "$1 "));
     System.out.println(randomLong(10000L, 1000000l).replaceAll("(\\d{3})(?=\\d)", "$1 ").replaceAll(" ", "-"));*/
}



