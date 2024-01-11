package com.ygback.domain.types;

/**
 * Created by IntelliJ IDEA.
 * User: Waqar Khan
 * To change this template use File | Settings | File Templates.
 */


import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.type.Type;

import java.util.List;

public abstract class AbstractTypedJsonNodeFunction extends AbstractJsonNodeFunction {
    private final String conversion;
    private final Type type;

    public AbstractTypedJsonNodeFunction(Type type, String conversion) {
        this.conversion = conversion;
        this.type = type;
    }

    @Override
    public Type getReturnType(Type firstArgumentType, Mapping mapping) {
        return type;
    }

    protected CharSequence doRender(Type firstArgumentType, List arguments, SessionFactoryImplementor factory) {
        StringBuilder sb = new StringBuilder();

        if (conversion != null) {
            sb.append('(');
        }

        buildPath(sb, arguments, -1).append("->>").append(arguments.get(arguments.size() - 1));

        if (conversion != null) {
            sb.append(")::").append(conversion);
        }

        return sb;
    }
}