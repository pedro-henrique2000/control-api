package com.controlfood.domain.entities;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public interface DomainEntity {

    default void assingValue(String field, Object value) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Field declaredField = this.getClass().getDeclaredField(field);
        declaredField.setAccessible(true);
        Type type = declaredField.getGenericType();
        if (type instanceof Class && ((Class<?>) type).isEnum()) {
            Method method = ((Class<?>) type).getMethod("from", String.class);
            declaredField.set(this, method.invoke(null, value));

            return;
        }
        declaredField.set(this, value);
    }
}
