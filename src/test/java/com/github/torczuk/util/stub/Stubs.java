package com.github.torczuk.util.stub;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class Stubs {
    private static final AtomicLong INC = new AtomicLong(0);

    public static Long inc() {
        return INC.incrementAndGet();
    }

    public static String uuid() {
        return UUID.randomUUID().toString();
    }
}
