package com.spring.multi.thread.utility;

public class HelperUtility {

    public static String[] generateAlphaArr() {
        String[] alphaArr = new String[26];
        for (int i = 0; i < alphaArr.length; i++) {
            alphaArr[i] = Character.toString((char) 'A' + i);
        }
        return alphaArr;
    }

    public static String[] generateNumArr() {
        String[] numArr = new String[26];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = String.valueOf(i + 1);
        }
        return numArr;
    }

    public static String[] generateRandomArr() {
        String[] randomArr = new String[26];
        for (int i = 0; i < randomArr.length; i++) {
            randomArr[i] = "!";
        }
        return randomArr;
    }

}
