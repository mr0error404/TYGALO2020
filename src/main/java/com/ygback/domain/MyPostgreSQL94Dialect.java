package com.ygback.domain;

/**
 * Created by IntelliJ IDEA.
 * User: Waqar Khan
 * To change this template use File | Settings | File Templates.
 */


import com.ygback.domain.types.*;
import org.hibernate.dialect.PostgreSQL94Dialect;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;


public class MyPostgreSQL94Dialect extends PostgreSQL94Dialect {

    public MyPostgreSQL94Dialect() {

        super();

        //this.registerColumnType(Types.JAVA_OBJECT, "jsonb");

        registerFunction("hql_jsonb_text", new TextJsonNodeFunction());
        registerFunction("hql_jsonb_bool", new BoolJsonNodeFunction());
        registerFunction("hql_jsonb_int", new IntegerJsonNodeFunction());
        registerFunction("hql_jsonb_long", new LongJsonNodeFunction());

        registerFunction("hql_jsonb_array_length", new JsonNodeFunction(IntegerType.INSTANCE, "array_length"));
        registerFunction("hql_jsonb_typeof", new JsonNodeFunction(StringType.INSTANCE, "typeof"));
        registerFunction("hql_jsonb_contains", new JsonNodeContainsFunction());
    }
}
