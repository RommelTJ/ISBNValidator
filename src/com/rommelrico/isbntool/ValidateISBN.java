package com.rommelrico.isbntool;

class ValidateISBN {

    boolean checkISBN(String ISBN) {
        int total = 0;

        for (int i = 0; i < 10; i++) {
            total += ISBN.charAt(i) * (10 - i);
        }

        return total % 11 == 0;
    }

}
