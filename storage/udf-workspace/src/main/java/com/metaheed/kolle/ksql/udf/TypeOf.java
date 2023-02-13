package com.metaheed.kolle.ksql.udf;


import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

@UdfDescription(name = "type_of", description = "logical type of description  ")
public class TypeOf {


    String emailExpression = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

    //["timestamp type" "" "(type_of string #yyyy-mm-dd $value )"]

    @Udf(description = " Return type of core type ")
    public boolean typeOf(@UdfParameter(value = "core_type", description = "input value") String coreType,
                          @UdfParameter(value = "regular_expression", description = "input value") String regvalue,
                          @UdfParameter(value = "actual_value", description = "input value") String actual_value) {

        if (actual_value == null) {
            return true;
        }

        switch (regvalue) {
            case "email":
                return actual_value.matches(emailExpression);

            default:
                return actual_value.matches(regvalue);
            // code block
        }

        //return true ;
    }


    public static void main(String... argv) {
        TypeOf v = new TypeOf();
        System.out.println(v.typeOf("string", "email2", "test@test.com"));


    }

}


