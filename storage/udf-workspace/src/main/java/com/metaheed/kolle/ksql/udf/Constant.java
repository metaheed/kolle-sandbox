package com.metaheed.kolle.ksql.udf;


import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

@UdfDescription(name = "constant", description = "return constant value ")
public class Constant {


    @Udf(description = "Always Constant value ")
    public Integer constantInt(
        @UdfParameter(value = "value", description = "constant value")
        Integer value) {
        return value;
    }

    @Udf(description = "Always Constant value ")
    public String constantString(
     @UdfParameter(value = "value", description = "constant value")
      String value) {
        return value;
    }

    @Udf(description = "Always Constant value ")
    public Long constantLong(
     @UdfParameter(value = "value", description = "constant value")
     Long value) {
        return value;
    }

    @Udf(description = "Always Constant value ")
    public Double constantDouble(
    @UdfParameter(value = "value", description = "constant value")
    Double value) {
        return value;
    }



}
