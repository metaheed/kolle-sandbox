package com.metaheed.kolle.ksql.udf;


import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

@UdfDescription(name = "castable", description = "check castable  ")
public class Castable {

    @Udf(description = " Return castbale value")
    public boolean castable(@UdfParameter(value = "value", description = "input value") String value,
                            @UdfParameter(value = "target_type", description = "input value") String targetType,
                            @UdfParameter(value = "source_type", description = "input value") String sourceType
                            ) {

        String regex = "\\d+";

        if ("double".equals(targetType))
            regex = "[0-9]{1,13}(\\.[0-9]*)?";
        else
            regex = "\\d+";

        if (value == null) {
            return true;
        } else {
            return value.matches(regex);
        }
    }


    public static void main(String... argv) {
        Castable v = new Castable();
        System.out.println(v.castable( "1233" , "string", "int"));
        System.out.println(v.castable( null , "string", "int"));
        System.out.println(v.castable( "123t3" , "string", "int"));
        System.out.println(v.castable( "" , "string", "int"));

    }

}


