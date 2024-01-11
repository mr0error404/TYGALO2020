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

public class JsonNodeFunction extends AbstractJsonNodeFunction {
    protected String functionName;
    protected Type type;

    JsonNodeFunction() {
        super();
        setMinimalArgumentCount(1);
    }

    public JsonNodeFunction(Type type, String functionName) {
        this();
        this.functionName = "jsonb_" + functionName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public Type getReturnType(Type firstArgumentType, Mapping mapping) {
        return type;
    }

    protected String doRender(Type firstArgumentType, List arguments, SessionFactoryImplementor factory) {
        StringBuilder sb = new StringBuilder();
        sb.append(functionName).append('(');
        buildPath(sb, arguments);
        sb.append(')');
        return sb.toString();
    }
}

