package org.texellent.testing;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@Order(3)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class MethodsOrderedByName {
    @Test
    void testD() {
        System.out.println("Running test D");
    }

    @Test
    void testA() {
        System.out.println("Running test A");
    }


    @Test
    void testC() {
        System.out.println("Running test C");
    }

    @Test
    void testB() {
        System.out.println("Running test B");
    }


}
