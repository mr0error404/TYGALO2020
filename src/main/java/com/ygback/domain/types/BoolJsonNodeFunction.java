package com.ygback.domain.types;

/**
 * Created by IntelliJ IDEA.
 * User: Waqar Khan
 * To change this template use File | Settings | File Templates.
 */


import org.hibernate.type.BooleanType;

public class BoolJsonNodeFunction extends AbstractTypedJsonNodeFunction {
    public BoolJsonNodeFunction() {
        super(BooleanType.INSTANCE, "boolean");
    }
}
