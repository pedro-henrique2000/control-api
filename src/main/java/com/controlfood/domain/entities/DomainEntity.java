package com.controlfood.domain.entities;

import com.controlfood.domain.errors.BusinessException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public interface DomainEntity {

    default void assingValue(String field, Object value) {
        try {
            Field declaredField = this.getClass().getDeclaredField(field);
            declaredField.setAccessible(true);
            Type type = declaredField.getGenericType();

            if (type instanceof Class && ((Class<?>)type).isEnum()) {
                Method method = ((Class<?>) type).getMethod("from", String.class);
                declaredField.set(this, method.invoke(null, value));

                return;
            }

            declaredField.set(this, value);
        }  catch (Exception exception) {
            exception.printStackTrace();
            throw new BusinessException("");
        }
    }

}
