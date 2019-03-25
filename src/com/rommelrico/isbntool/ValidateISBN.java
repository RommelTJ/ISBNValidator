package com.rommelrico.isbntool;

class ValidateISBN {

    boolean checkISBN(String ISBN) {
        if (ISBN.length() != 10) throw new NumberFormatException("Invalid Number Format");
        if (ISBN.matches(".*[a-zA-Z&&[^xX]]+.*")) throw new NumberFormatException("Invalid Number Format");

        int total = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 9 && !Character.isDigit(ISBN.charAt(i)) && ISBN.charAt(i) != 'X')
                throw new NumberFormatException("Invalid Number Format");

            total += ISBN.charAt(i) * (10 - i);
        }

        return total % 11 == 0;
    }

}
