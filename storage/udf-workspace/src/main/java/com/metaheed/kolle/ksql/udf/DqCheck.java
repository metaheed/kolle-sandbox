package com.metaheed.kolle.ksql.udf;


import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

import java.util.HashSet;
import java.util.StringTokenizer;

@UdfDescription(name = "dq_check", description = "check castable  ")
public class DqCheck {

    @Udf(description = " Return dqcheck value")
    public boolean dqcheck(@UdfParameter(value = "op", description = "input value") String op,
                            @UdfParameter(value = "expected_value", description = "input value") String expected_value,
                            @UdfParameter(value = "actual_value", description = "input value") String actual_value) {

        if ( actual_value == null ){
            return true;
        }

        switch(op) {
            case "contain?":
                HashSet<String> myHashSet = new HashSet(500000);  // Or a more realistic size
                StringTokenizer st = new StringTokenizer(expected_value, ",");
                while(st.hasMoreTokens())
                    myHashSet.add(st.nextToken());
                return myHashSet.contains(actual_value);
            case "length":
                Integer length = actual_value.length();
                Integer targetLenght = Integer.parseInt(expected_value);
                // code block
                return length.equals(targetLenght);
            default:
                return true;
                // code block
        }

        //return true ;
    }


    public static void main(String... argv) {
        DqCheck v = new DqCheck();
        System.out.println(v.dqcheck( "contain?" , "1,2,3", "4"));
        System.out.println(v.dqcheck( "length" , "4", "test"));


    }

}


