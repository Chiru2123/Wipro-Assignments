package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class add2Number {
    int add2Num(int a, int b) {
        return a + b;
    }
}

class evenOrOdd {
    public boolean isEven(int x) {
        return x % 2 == 0;
    }
}

class junit_example1 {

    @BeforeAll
    static void setupAll() {
        System.out.println("@BeforeAll -----> Run once before all tests");
    }

    @BeforeEach
    void setup() {
        System.out.println("@BeforeEach -----> Run before each test");
    }

    @AfterEach
    void teardown() {
        System.out.println("@AfterEach -----> Run after each test");
    }

    @AfterAll
    static void teardownAll() {
        System.out.println("@AfterAll -----> Run once after all tests");
    }

    @Test
    @DisplayName("This is demo testcase")
    void test() {
        System.out.println("Test 1: hello chiru");
    }

    @Test
    void test2values() {
        int actualValue = 3;
        int expectedValue = 3;
        int unExpectedValue = 4;

        assertEquals(actualValue, expectedValue);
        assertNotEquals(unExpectedValue, actualValue);
        System.out.println("Test 2: test2values");
    }

    @Test
    @DisplayName("Class 2 add number")
    void test2NumbersAdding() {
        add2Number add = new add2Number();
        int actualAddNumber = add.add2Num(2, 3);
        int expectedValues = 5;

        assertEquals(expectedValues, actualAddNumber);
        System.out.println("Test 3: test2NumbersAdding");
    }

    @Test
    @DisplayName("assertTrue for Even or Odd")
    void checkEvenOrOdd() {
        evenOrOdd e = new evenOrOdd();
        assertTrue(e.isEven(4));
        assertFalse(e.isEven(3));
        System.out.println("Test 4: checkEvenOrOdd");
    }

    @Test
    void testObjectCreation() {
        String str2 = "rk";
        assertNotNull(str2);
        System.out.println("Test 5: testObjectCreation");
    }
}
