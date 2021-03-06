package com.aliyun.tair.tests;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.ComparisonFailure;

public class AssertUtil extends Assert{

    public static void assertEquals(List<byte[]> expected, List<byte[]> actual) {
        assertEquals(expected.size(), actual.size());
        for (int n = 0; n < expected.size(); n++) {
            assertArrayEquals(expected.get(n), actual.get(n));
        }
    }

    public static void assertEquals(Set<byte[]> expected, Set<byte[]> actual) {
        assertEquals(expected.size(), actual.size());
        Iterator<byte[]> e = expected.iterator();
        while (e.hasNext()) {
            byte[] next = e.next();
            boolean contained = false;
            for (byte[] element : expected) {
                if (Arrays.equals(next, element)) {
                    contained = true;
                }
            }
            if (!contained) {
                throw new ComparisonFailure("element is missing",
                        Arrays.toString(next), actual.toString());
            }
        }
    }

}
