package org.texellent.testing;

import org.junit.jupiter.api.*;
import org.texellent.testing.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Order(4)
public class DemoRepeatedTest {

    Calculator calculator;

    @BeforeEach
    void beforeEachTestMethod() {
        Calculator calculator = new Calculator();
        System.out.println("Executing @BeforeEach method");
    }

    @AfterEach
    void afterEachMethod() {
        System.out.println("Executing @AfterEach method");
    }

    @RepeatedTest(value = 3, name = "{displayName}. Repetition {currentRepetition} of " + "{totalRepetitions}")
    @DisplayName("Divide by zero")
    void testIntegerDivision_WhenFourDividedByZero_ShouldThrowArithmeticException(RepetitionInfo repetitionInfo
            , TestInfo testInfo) {

        System.out.println("Repetition number " + repetitionInfo.getCurrentRepetition() +
                " of " + repetitionInfo.getTotalRepetitions());
        System.out.println("Running " + testInfo.getTestMethod().get().getName());
        //Arrange
        int dividend = 4;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";
        calculator = new Calculator();

        //Act   and assert
        ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> {
            //Act
            calculator.integerDivision(dividend, divisor);
        }, "Division by zero should have thrown an Arithmetic Exception");

        //assert
        assertEquals(expectedExceptionMessage, actualException.getMessage(), "Unexpected exception message");
    }
}
