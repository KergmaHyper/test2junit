package test2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg {

    static boolean isColor(String colorCode) {
        return colorCode.matches("(^#[\\da-fA-F]{6}$)|(^#[\\da-fA-F]{3}$)");
    }

    static boolean validateEpamEmail(String emailStr) {
        Pattern emailPattern = Pattern.compile("^[a-zA-Z]+_[a-zA-Z]+\\d*@epam.com$");
        Matcher emailMatch = emailPattern.matcher(emailStr);

        return emailMatch.find();
    }

    public static void main(String[] args) {
        // System.out.println(isColor("#663337"));
        String[] validEmail = {
                "william_shakespeare@epam.com",
                "lu_e@epam.com",
                "william_shakespeare1@epam.com",
                "william_shakespeare2@epam.com" };

        String[] invalidEmail = {
                "william@epam.com",
                "william.shakespeare@epam.com",
                "william...shakespeare@epam.com",
                "william-shakespeare@epam.com",
                "shakespeare123@epam.com",
                "william_$hakespeare@epam.com" };

        for (String em : validEmail) {
            System.out.println(
                    validateEpamEmail(em));
        }
        for (String em : invalidEmail) {
            System.out.println(
                    validateEpamEmail(em));
        }
    }
}