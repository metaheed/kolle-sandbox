package com.metaheed.kolle.ksql.udf;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@UdfDescription(name = "change_date_format", description = "return md5 hash value ")
public class ChangeDateFormat {

    @Udf(description = "Change date format ")
    public String changeDateFormat(@UdfParameter(value = "value", description = "input value") String value, @UdfParameter(value = "inputFormat", description = "input format") String inputFormat, @UdfParameter(value = "inputFormat", description = "output format") String ouputFormat) {
        if (value == null) {
            return value;
        }


        try {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(inputFormat);
            Date inputDate = simpleDateFormat.parse(value);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(inputDate);
            //calendar.add(Calendar.DATE, totalDays);


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
    //
    //change-format "01-01-2019" "dd-MM-yyyy" "ddMMMyyyy HH:mm:ss"
    public static void main(String args[]) throws NoSuchAlgorithmException {
        String s = "GeeksForGeeks";
        System.out.println("Your HashCode Generated by MD5 is: " + new ChangeDateFormat().changeDateFormat("01/01/2019", "dd/MM/yyyy", "ddMMMyyyy HH:mm:ss"));
    }
}
