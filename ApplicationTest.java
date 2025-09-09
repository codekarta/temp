import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Tests (JUnit 5)")
class ApplicationTest {

    private Calculator calculator;

    @BeforeAll
    static void setUpClass() {
        System.out.println("Executing before the entire test class (JUnit 5).");
    }

    @AfterAll
    static void tearDownClass() {
        System.out.println("Executing after the entire test class (JUnit 5).");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Executing before each test method (JUnit 5).");
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Executing after each test method (JUnit 5).");
    }

    @Test
    @DisplayName("Test for adding a single number")
    void testSingleAddition() {
        calculator.add(5);
        assertEquals(5, calculator.getResult());
    }

    // Grouped assertions
    @Test
    @DisplayName("Test multiple assertions with assertAll")
    void testMultipleAssertions() {
        calculator.add(10);
        assertAll("calculator",
            () -> assertEquals(10, calculator.getResult(), "Addition is wrong"),
            () -> assertTrue(calculator.isPositive(calculator.getResult()), "Result should be positive")
        );
    }

    // Exception handling with assertThrows
    @Test
    @DisplayName("Test for division by zero using assertThrows")
    void testDivisionByZero_assertThrows() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    // Parameterized test using CsvSource
    @ParameterizedTest(name = "Addition with {0} and {1} should be {2}")
    @CsvSource({
        "1.0, 1.0, 2.0",
        "2.0, 3.0, 5.0"
    })
    @DisplayName("Parameterized test for addition")
    void testAdditionFromCsvSource(double a, double b, double expected) {
        calculator.add(a);
        calculator.add(b);
        assertEquals(expected, calculator.getResult());
    }

    // Ignored test
    @Disabled("This test is disabled for now")
    @Test
    @DisplayName("Test that is currently disabled")
    void testDisabledMethod() {
        fail("This test should not be run.");
    }
}
