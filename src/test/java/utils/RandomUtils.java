package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;


public class RandomUtils {

    public static void main(String[] args) {
        RandomUtils randomUtils = new RandomUtils();
        System.out.println(randomUtils.randomString(10));
        System.out.println(randomEmail(10));
        System.out.println(randomLong(10));
        System.out.println(randomLong2(10000L, 1000000l));
        System.out.println(randomPhone("+7", 10));
        System.out.println(generatedString);


//        System.out.println(randomLong2(10000L, 1000000l).replaceAll("(\\d{3})(?=\\d)", "$1 "));
//        System.out.println(randomLong2(10000L, 1000000l).replaceAll("(\\d{3})(?=\\d)", "$1 ").replaceAll(" ", "-"));




        System.out.println();
    }

    static String randomString(int len){
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString() +"!";
    }

    static String randomEmail(int len){// to lower case
        return randomString(len).toLowerCase() + "@gmail.com";
    }

    static Long randomLong(int lenArg){
        final String AB = "0123456789";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(lenArg);
        for(int i = 0; i < lenArg; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return Long.parseLong(sb.toString());
    }
    static Long randomLong2(Long minArg, Long maxArg){
       // return (long) (Math.random() * (max - min + 1) + min);
        return ThreadLocalRandom.current().nextLong(minArg, maxArg + 1);
    }
    static String randomPhone(String countryCode, int lenArg){
        return countryCode + randomLong(lenArg);

    }
    static String generatedString = RandomStringUtils.random(20, true, true);

}



