package hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MainHWTests {
    private MainHW mainHW;
    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 8, 32, 100})
    void evenNumberTest(int n) {
        assertTrue(mainHW.evenOddNumbers(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 15, 101, 333})
    void oddNumberTest(int n) {
        assertFalse(mainHW.evenOddNumbers(n));
    }

    @Test
    void numberInIntervalTest() {
        assertTrue(mainHW.numberIninterval(50));
        assertFalse(mainHW.numberIninterval(25));
        assertFalse(mainHW.numberIninterval(100));
    }

}
