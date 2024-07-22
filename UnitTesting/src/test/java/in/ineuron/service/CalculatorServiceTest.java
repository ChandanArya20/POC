package in.ineuron.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    @BeforeAll
    static void init(){
        System.out.println("Before test cases");
    }

    @BeforeEach
    void inform(){
        System.out.println("new test case executed");
    }

    @AfterEach
    void takeRest() throws InterruptedException {
        System.out.println("Taking rest");
        Thread.sleep(1000);
    }

    @Test
    void addTest1() {
        assertEquals(4, CalculatorService.add(2, 2));
    }

    @Test
    void addTest2() {
        assertEquals(5, CalculatorService.add(2, 3));
    }

    @ParameterizedTest
    @CsvSource({
            "12,13,25",
            "5,60,65",
            "100,150,250",
    })
    @Disabled
    void addTest3(int a, int b, int expected ) {
        assertEquals(expected, CalculatorService.add(a, b));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Ram",
            "Chandan",
            "",
            "Cat"
    })
    void checkStringLength(String str){
        assertTrue(str.length() > 0);
    }

    @Test
    void sub() {
    }

    @Test
    void mul() {
    }

    @AfterAll
    static void cleanUp(){
        System.out.println("After all test cases");
    }
}