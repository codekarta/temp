import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ApplicationTest {

    private final double valueA;
    private final double valueB;
    private final double expectedResult;
    private Calculator calculator;

    public CalculatorJunit4Test(double valueA, double valueB, double expectedResult) {
        this.valueA = valueA;
        this.valueB = valueB;
        this.expectedResult = expectedResult;
    }

    // Parameters for the parameterized test
    @Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
            {1.0, 1.0, 2.0},
            {2.0, 3.0, 5.0}
        });
    }

    // Rule for exception handling
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Executing before the entire test class (JUnit 4).");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Executing after the entire test class (JUnit 4).");
    }

    @Before
    public void setUp() {
        System.out.println("Executing before each test method (JUnit 4).");
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("Executing after each test method (JUnit 4).");
    }

    @Test
    public void testAddition() {
        calculator.add(valueA);
        calculator.add(valueB);
        assertEquals(expectedResult, calculator.getResult(), 0.0);
    }

    // Exception handling with ExpectedException rule
    @Test
    public void testDivisionByZero_rule() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot divide by zero");
        calculator.divide(0);
    }

    // Ignored test
    @Ignore("This test is ignored for now")
    @Test
    public void testIgnoredMethod() {
        fail("This test should not be run.");
    }
}
