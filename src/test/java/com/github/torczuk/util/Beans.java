package com.github.torczuk.util;

import org.apache.commons.beanutils.BeanUtils;

public class Beans {
    public static <T> T getProperty(Object o, String name) {
        try {
            return (T) BeanUtils.getProperty(o, name);
        } catch (Exception e) {
            return null;
        }
    }
}
