package test2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import lombok.SneakyThrows;

public class App {
    public static void main(String[] args) {

        Date dtNow = new Date();
        SimpleDateFormat dtF = new SimpleDateFormat("EddMMhhmm", Locale.US);
        String psswd = dtF.format(dtNow);
        String emlAddr = psswd.concat("@test.email");
        System.out.printf("E-mail: '%s', password: '%s'\n", emlAddr, psswd);

    }
}
