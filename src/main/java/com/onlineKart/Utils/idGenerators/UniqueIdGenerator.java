package com.onlineKart.Utils.idGenerators;

import java.util.concurrent.atomic.AtomicLong;

public class UniqueIdGenerator {
	 private static final AtomicLong counter = new AtomicLong(System.currentTimeMillis());

	    public static long generateUniqueId() {
	        return counter.incrementAndGet();
	    }

	    public static void main(String[] args) {
	        long uniqueId = generateUniqueId();
	        System.out.println("Unique ID: " + uniqueId);
	    }
	}