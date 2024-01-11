package com.ygback.domain.types;

/**
 * Created by IntelliJ IDEA.
 * User: Waqar Khan
 * To change this template use File | Settings | File Templates.
 */



import org.hibernate.type.StringType;

public class TextJsonNodeFunction extends AbstractTypedJsonNodeFunction
{
    public TextJsonNodeFunction()
    {
        super(StringType.INSTANCE, null);
    }
}