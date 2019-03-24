package com.rommelrico.isbntool;

import org.junit.jupiter.api.Test;

import java.text.*;

import static org.junit.jupiter.api.Assertions.*;

/*
Rules of TDD:
1. Test the expected outcome of an example.
 -> Valid ISBN, Invalid ISBN
2. Don't pre-judge design... let your tests drive it.
 -> Don't assume ISBNs have to be Strings.
3. Write the minimum code required to get your tests to pass.
 -> Make method to always return true.
4. Each test should validate one single piece of logic.
 */
class ValidateISBNTest {

    @Test
    void checkValidISBN() {
        ValidateISBN validator = new ValidateISBN();

        boolean result = validator.checkISBN("0140449116");
        assertTrue(result, "first value");

        result = validator.checkISBN("0140177396");
        assertTrue(result, "second value");
    }

    @Test
    void checkInvalidISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0150449116");
        assertFalse(result);
    }

    @Test
    void nineDigitISBNSNotAllowed() {
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class, () -> validator.checkISBN("123456789"));
    }

    @Test
    void wordsNotAllowed() {
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class, () -> validator.checkISBN("helloworld"));
    }



}