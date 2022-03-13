package com.yuxiang.file.server.search;

import io.netty.util.internal.PlatformDependent;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhangyux
 * @version 1.0
 * @date 2022/3/11 15:16
 */
public class DirectMemoryCounterTest {

    public static void main(String[] args) {
        Field field = ReflectionUtils.findField(PlatformDependent.class, "DIRECT_MEMORY_COUNTER");
        field.setAccessible(true);
        try {
            AtomicLong directMemory = (AtomicLong) field.get(PlatformDependent.class);
            System.out.println("DIRECT_MEMORY_COUNTER: " + directMemory);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
