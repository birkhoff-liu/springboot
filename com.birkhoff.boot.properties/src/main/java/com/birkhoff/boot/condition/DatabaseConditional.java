package com.birkhoff.boot.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DatabaseConditional implements Condition {
    /**
     * 数据库bean的装配条件判断
     * @param conditionContext
     * @param annotatedTypeMetadata
     * @return
     */

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        if(environment.containsProperty("database.driverName") && environment.containsProperty("database.url")
           && environment.containsProperty("database.username") && environment.containsProperty("database.password")){
            return true;
        }
        return false;
    }
}
