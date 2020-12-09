package br.com.ilog.test.utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 *
 * @author jonny
 */
public class IgnoreField {

    public static ExclusionStrategy getStrategy(String fieldToIgnore, Class target) {
        ExclusionStrategy strategy = new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes field) {
                return field.getDeclaringClass() == target && field.getName().equals(fieldToIgnore);
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };
        return strategy;
    }
}
