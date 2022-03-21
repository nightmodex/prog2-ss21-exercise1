import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DynamicTest;

class ResultTest {
    //https://github.com/nightmodex/prog2-ss21-exercise1
    Result result;

    @BeforeEach
    void setUp() {
        result = new Result();
    }

    @Test
    @DisplayName("Check if two numbers are rounded/not rounded")
    void roundToNextMultipleOfFive(){
        assertEquals(60, result.roundToNextMultipleOfFive(58), "Rounding does not work as expected.");
        assertEquals(57, result.roundToNextMultipleOfFive(57), "Rounding does not work as expected.");
    }

    @TestFactory
    @DisplayName("Round multiple numbers")
    Stream<DynamicTest> multipleRoundings(){
        int[][] values = new int[][] {{58,60}, {77,77}, {12,12}, {40,40}, {94,95}, {99,100}, {42, 42}};
        return Arrays.stream(values).map(data->{
            int input = data[0];
            int expected = data[1];
            return DynamicTest.dynamicTest((input>40 & (expected-input)<3) ? input+"/"+5+"*"+5+"+"+5+"="+expected : input+" not rounded", ()-> assertEquals(expected, result.roundToNextMultipleOfFive(input)));
        });
    }

    @Test
    @DisplayName("Check input below 1")
    void checkRangeBelowOne(){
        assertFalse(result.checkRange(-1));
    }

    @Test
    @DisplayName("Check input in range (1-60)")
    void checkInputInRange(){
        assertTrue(result.checkRange(58));
    }

    @Test
    @DisplayName("Check input above 60")
    void checkRangeAboveRange(){
        assertFalse(result.checkRange(65));
    }

    @Test
    @DisplayName("Check if list contains null elements")
    void checkNullElementsInList(){
        List<Integer> lsitWithNullElements = Arrays.asList(64,29,null, 84);
        assertTrue(result.containsNullElements(lsitWithNullElements));
    }

    @Test
    @DisplayName("Check if list contains no null elements")
    void checkNoNullElementsInList(){
        List<Integer> lsitWithNoNullElements = Arrays.asList(64,29,93, 4);
        assertFalse(result.containsNullElements(lsitWithNoNullElements));
    }
}