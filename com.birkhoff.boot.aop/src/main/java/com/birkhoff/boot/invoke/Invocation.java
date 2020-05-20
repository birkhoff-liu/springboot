package com.birkhoff.boot.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Invocation {
    private Object[] params;
    private Method method;
    private Object target;

    public Invocation(Object target,Method method,Object[] params){
        this.method = method;
        this.target = target;
        this.params = params;
    }

    /**
     * 反射方法
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public Object proceed() throws InvocationTargetException,IllegalAccessException{
        return this.method.invoke(target,params);
    }
}
