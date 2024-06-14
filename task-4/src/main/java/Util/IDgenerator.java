package Util;

import java.util.concurrent.atomic.AtomicInteger;

public class IDgenerator {
    private static AtomicInteger atomicInteger;

    public IDgenerator() {
        atomicInteger = new AtomicInteger(1);
    }

    public static int get() {
        return atomicInteger.getAndIncrement();
    }
}