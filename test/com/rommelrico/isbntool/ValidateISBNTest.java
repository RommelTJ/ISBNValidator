package com.rommelrico.isbntool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
Rules of TDD:
1. Test the expected outcome of an example.
 -> Valid ISBN, Invalid ISBN
2. Don't pre-judge design... let your tests drive it.
 -> Don't assume ISBNs have to be Strings.
 */
class ValidateISBNTest {

    @Test
    public void checkValidISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN(140449116);
        assertTrue(result);
    }

}