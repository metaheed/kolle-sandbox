package com.metaheed.kolle.ksql.udf;


import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;

@UdfDescription(name = "vnull", description = "return always null value ")
public class Vnull {

    @Udf(description = "Always Constant value ")
    public String vnull() {
        return null;
    }




}
