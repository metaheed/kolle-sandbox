package com.metaheed.kolle.ksql.udf;


import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;

import java.util.Random;

@UdfDescription(name = "email", description = "return random email")
public class Email {

    public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    @Udf(description = "Always return random email ")
    public String email() {
        Random rnd = new Random(5);
        if (rnd.nextInt() == 2) {
            return "";

        } else {
            return getSaltString() + "@test.org";
        }

    }
}
