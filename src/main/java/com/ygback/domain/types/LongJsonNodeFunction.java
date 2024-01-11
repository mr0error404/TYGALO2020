package com.ygback.domain.types;


/**
 * Created by IntelliJ IDEA.
 * User: Waqar Khan
 * To change this template use File | Settings | File Templates.
 */

import org.hibernate.type.LongType;

public class LongJsonNodeFunction extends AbstractTypedJsonNodeFunction
{
    public LongJsonNodeFunction()
    {
        super(LongType.INSTANCE, "bigint");
    }
}

