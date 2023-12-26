package org.texellent.testing;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.texellent.testing.Calculator;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Order(5)
@DisplayName("Test Math Operations in Calculator class")
public class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void setup() {
        System.out.println("Executing @BeforeAll method");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Executing @AfterAll method");
    }

    @BeforeEach
    void beforeEachTestMethod() {
        calculator = new Calculator();
        System.out.println("Executing @BeforeEach method");
    }

    @AfterEach
    void afterEachMethod() {
        System.out.println("Executing @AfterEach method");
    }

    @ParameterizedTest
    @ValueSource(strings = {"mailar", "amit", "ajit"})
    void testStringParameterValue(String firstName) {
        System.out.println(firstName);
        assertNotNull(firstName);
    }

    @ParameterizedTest
    @DisplayName(" CSV Source Parameterized Integer subtraction [minend, subend, expectedResult] withd")
    @CsvSource({
            "33,1,32",
            "44,1,43",
            "45,2,43"
    })
        //For strings
        //  @CsvSource({
        //          "apple,orange",
        //          "apple,''", //empty second string
        //          "apple," //null second string
        //  })
    void testCsvSourceIntegerSubtraction(int minuend, int subtend, int expectedResult) {

        System.out.println("Running test " + minuend + " -" + subtend + "= " + expectedResult);

        int result = calculator.integerSubtraction(minuend, subtend);

        assertEquals(expectedResult, result, () -> minuend + "-" + subtend + "  did not yield " + expectedResult);
    }


    @ParameterizedTest
    @DisplayName(" CSV File Parameterized Integer subtraction [minend, subend, expectedResult] withd")
    @CsvFileSource(resources = "/integerSubtraction.csv")
    void testCsVFileSourceIntegerSubtraction(int minuend, int subtend, int expectedResult) {

        System.out.println("Running test " + minuend + " -" + subtend + "= " + expectedResult);

        int result = calculator.integerSubtraction(minuend, subtend);

        assertEquals(expectedResult, result, () -> minuend + "-" + subtend + "  did not yield " + expectedResult);
    }

    //***********************************************************start****************
    public static Stream<Arguments> testIntegerSubtractionParametersMethod() {
        return Stream.of(
                Arguments.of(100, 1, 99),
                Arguments.of(200, 1, 199),
                Arguments.of(300, 1, 299)
        );
    }

    @ParameterizedTest
    @DisplayName("Parameterized Method Source -different Method Name  Integer subtraction [minend, subend, expectedResult]")
    @MethodSource("testIntegerSubtractionParametersMethod")
    void testParameterizedDifferentParameterSourceMethodNameIntegerSubtraction(int minuend, int subtend, int expectedResult) {

        System.out.println("Running test " + minuend + " -" + subtend + "= " + expectedResult);

        int result = calculator.integerSubtraction(minuend, subtend);

        assertEquals(expectedResult, result, () -> minuend + "-" + subtend + "  did not yield " + expectedResult);
    }
    //***********************************************************end****************

    //***********************************************************start****************
    public static Stream<Arguments> testParameterizedSameParameterSourceMethodNameIntegerSubtraction() {
        return Stream.of(
                Arguments.of(100, 1, 99),
                Arguments.of(200, 1, 199),
                Arguments.of(300, 1, 299)
        );
    }

    @ParameterizedTest
    @DisplayName("Parameterized Method Source -same  Method Name  Integer subtraction [minend, subend, expectedResult]")
    @MethodSource()
    void testParameterizedSameParameterSourceMethodNameIntegerSubtraction(int minuend, int subtend, int expectedResult) {

        System.out.println("Running test " + minuend + " -" + subtend + "= " + expectedResult);

        int result = calculator.integerSubtraction(minuend, subtend);

        assertEquals(expectedResult, result, () -> minuend + "-" + subtend + "  did not yield " + expectedResult);
    }
    //***********************************************************end ****************


    @Disabled
    @Test
    @DisplayName("Test 4/2=2")
    void testIntegerDivision_WhenFourDividedByTwo_ShouldReturnTwo() {

        System.out.println("Running test 4/2");

        //Arrange //Given
        int dividend = 4;
        int divisor = 2;
        //Act //When
        int result = calculator.integerDivision(dividend, divisor);

        //Assert //Then
        assertEquals(2, result, "4/2 did not produce 2");
    }

    @Disabled("TODO: still need to work on it")
    @Test
    @DisplayName("Divide by zero")
    void testIntegerDivision_WhenFourDividedByZero_ShouldThrowArithmeticException() {
        System.out.println("Running test 4/0");
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

    @Disabled
    @Test
    @DisplayName("Test 5-2=3")
    void testIntegerSubtraction_WhenFiveMinusTwo_ShouldReturnThree() {

        System.out.println("Running test 5-2 ");

        int minuend = 5;
        int subtend = 2;
        int result = calculator.integerSubtraction(minuend, subtend);
        int expectedResult = 3;
        assertEquals(expectedResult, result, () -> minuend + "-" + subtend + "  did not yield " + expectedResult);
    }
}
