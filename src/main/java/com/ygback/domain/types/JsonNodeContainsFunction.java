package com.ygback.domain.types;

import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.type.Type;

import java.util.List;

public class JsonNodeContainsFunction extends AbstractJsonNodeFunction implements SQLFunction
{

    @Override
    protected String doRender(Type firstArgumentType, List arguments, SessionFactoryImplementor factory)
    {
        StringBuilder sb = new StringBuilder();
        super.buildPath(sb, arguments, -1)
                .append("@>")
                .append(arguments.get(arguments.size() - 1))
                .append("::jsonb");
        return sb.toString();
    }

}