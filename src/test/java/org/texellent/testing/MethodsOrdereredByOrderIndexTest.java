package org.texellent.testing;

import org.junit.jupiter.api.*;

@Order(1)
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // should concatenate values 1234 .
//@TestInstance(TestInstance.Lifecycle.PER_METHOD) // DEFAULT: should PRINT individual  values like 1 and 2 and 3 and 4 .

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodsOrdereredByOrderIndexTest {

    StringBuilder completed = new StringBuilder("");

    @AfterEach
    void afterEach() {
        System.out.println("The state of each object is " + completed);
    }


    @Order(1)
    @Test
    void testD() {

        System.out.println("Running test D");
        completed.append("1");
    }

    @Order(2)
    @Test
    void testA() {
        System.out.println("Running test A");
        completed.append("2");
    }

    @Order(3)
    @Test
    void testC() {
        System.out.println("Running test C");

        completed.append("3");
    }

    @Order(4)
    @Test
    void testB() {
        System.out.println("Running test B");
        completed.append("4");
    }


}

