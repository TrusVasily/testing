import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTests {
    @DisplayName("First Test")
    @Test
    void firstUnitTest(){
        assertFalse(TriangleInquety.Check(1, 2, 3));
    }

    @DisplayName("Second Test")
    @Test
    void secondUnitTest(){
        assertTrue(TriangleInquety.Check(2, 4, 4));
    }

    @DisplayName("Third Test")
    @Test
    void thirdUnitTest(){
        assertTrue(TriangleInquety.Check(4, 4, 2));
    }

    @DisplayName("Fourth Test")
    @Test
    void fourthUnitTest(){
        assertFalse(TriangleInquety.Check(1, 0, 3));
    }

    @DisplayName("Fifth Test")
    @Test
    void fifthUnitTest(){
        assertFalse(TriangleInquety.Check(1, -2, 0));
    }

    @DisplayName("Sixth Test")
    @Test
    void sixthUnitTest(){
        assertTrue(TriangleInquety.Check(1, 1, 1));
    }

    @DisplayName("Seventh Test")
    @Test
    void seventhUnitTest(){
        assertFalse(TriangleInquety.Check(1, -1, 1));
    }

    @DisplayName("Eighth Test")
    @Test
    void eighthUnitTest(){
        assertFalse(TriangleInquety.Check(0, 2, 0));
    }

    @DisplayName("Ninth Test")
    @Test
    void ninthUnitTest(){
        assertTrue(TriangleInquety.Check(10, 2, 10));
    }

    @DisplayName("Final Test")
    @Test
    void tenthUnitTest(){
        assertFalse(TriangleInquety.Check(3, 100, 2));
    }

}
