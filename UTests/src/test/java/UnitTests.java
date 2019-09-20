import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTests {
    @DisplayName("First Test")
    @Test
    void FirstUnitTest(){
        assertEquals(TriangleInquety.Check(1,2,3), false);
    }

    @DisplayName("Second Test")
    @Test
    void SecondUnitTest(){
        assertEquals(TriangleInquety.Check(2,4,4), true);
    }

    @DisplayName("Third Test")
    @Test
    void ThirdUnitTest(){
        assertEquals(TriangleInquety.Check(4,4,2), true);
    }

    @DisplayName("Fourth Test")
    @Test
    void FourthUnitTest(){
        assertEquals(TriangleInquety.Check(1,0,3), false);
    }

    @DisplayName("Fifth Test")
    @Test
    void FifthUnitTest(){
        assertEquals(TriangleInquety.Check(1,-2,0), false);
    }

    @DisplayName("Sixth Test")
    @Test
    void SixthUnitTest(){
        assertEquals(TriangleInquety.Check(1,1,1), true);
    }

    @DisplayName("Seventh Test")
    @Test
    void SeventhUnitTest(){
        assertEquals(TriangleInquety.Check(1,-1,1), false);
    }

    @DisplayName("Eighth Test")
    @Test
    void EighthUnitTest(){
        assertEquals(TriangleInquety.Check(0,2,0), false);
    }

    @DisplayName("Ninth Test")
    @Test
    void NinthUnitTest(){
        assertEquals(TriangleInquety.Check(10,2,10), true);
    }

    @DisplayName("Final Test")
    @Test
    void TenthUnitTest(){
        assertEquals(TriangleInquety.Check(3,100,2), false);
    }

}
