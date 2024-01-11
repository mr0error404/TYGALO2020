package com.ygback.domain.types;

/**
 * Created by IntelliJ IDEA.
 * User: Waqar Khan
 * To change this template use File | Settings | File Templates.
 */


import com.google.common.base.Preconditions;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.type.BooleanType;
import org.hibernate.type.Type;

import java.util.List;

public abstract class AbstractJsonNodeFunction implements SQLFunction {
    protected int minimalArgumentCount = 2;
    protected int maximalArgumentCount = 32;

    public int getMinimalArgumentCount() {
        return minimalArgumentCount;
    }

    public void setMinimalArgumentCount(int minimalArgumentCount) {
        this.minimalArgumentCount = minimalArgumentCount;
    }

    public int getMaximalArgumentCount() {
        return maximalArgumentCount;
    }

    public void setMaximalArgumentCount(int maximalArgumentCount) {
        this.maximalArgumentCount = maximalArgumentCount;
    }

    @Override
    public boolean hasArguments() {
        return true;
    }

    @Override
    public boolean hasParenthesesIfNoArguments() {
        return false;
    }

    @Override
    public Type getReturnType(Type firstArgumentType, Mapping mapping) {
        return BooleanType.INSTANCE;
    }

    public StringBuilder buildPath(StringBuilder sb, List arguments) {
        return buildPath(sb, arguments, 0, arguments.size());
    }

    public StringBuilder buildPath(StringBuilder sb, List arguments, int n) {
        return buildPath(sb, arguments, 0, n < 0 ? arguments.size() + n : n);
    }

    public StringBuilder buildPath(StringBuilder sb, List arguments, int from, int to) {
        sb.append(arguments.get(from));
        for (int i = from + 1; i < to; i++) {
            sb.append("->").append(arguments.get(i));
        }
        return sb;
    }

    @Override
    public final String render(Type firstArgumentType, List arguments, SessionFactoryImplementor factory){
        int argc = arguments.size();
        Preconditions.checkArgument(argc >= minimalArgumentCount, "At least %s arguments got %s", minimalArgumentCount, argc);
        Preconditions.checkArgument(argc <= maximalArgumentCount, "At most %s arguments got %s", maximalArgumentCount, argc);
        return doRender(firstArgumentType, arguments, factory).toString();
    }

    protected abstract CharSequence doRender(Type firstArgumentType, List arguments, SessionFactoryImplementor factory);
}