package com.metaheed.kolle.ksql.udf;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@UdfDescription(name = "add_years", description = "Return after add years ")
public class AddYears {

    @Udf(description = "Add year to current date ")
    public String addyears(@UdfParameter(value = "value", description = "input value") String value, @UdfParameter(value = "totalYears", description = "total days") int totalYears, @UdfParameter(value = "inputFormat", description = "input format") String inputFormat, @UdfParameter(value = "inputFormat", description = "ouput format") String ouputFormat) {
        if (value == null) {
            return value;
        }


        try {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(inputFormat);
            Date inputDate = simpleDateFormat.parse(value);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(inputDate);
            calendar.add(Calendar.YEAR, totalYears);


            SimpleDateFormat outputDateFormat = new SimpleDateFormat(ouputFormat);
            outputDateFormat.setCalendar(calendar);
            return outputDateFormat.format(calendar.getTime());
        }

        // For specifying wrong message digest algorithms
        catch (Exception e) {
            return value;
        }
    }

    // Driver code
    public static void main(String args[]) throws NoSuchAlgorithmException {
        String s = "GeeksForGeeks";
        System.out.println("Your HashCode Generated by MD5 is: " + new AddYears().addyears("01/01/2019", 1, "dd/MM/yyyy", "dd-MM-yyyy"));

    }
}
