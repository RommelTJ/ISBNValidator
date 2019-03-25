package com.rommelrico.isbntool;

class ValidateISBN {

    boolean checkISBN(String ISBN) {
        if (ISBN.length() != 10 && ISBN.length() != 13) throw new NumberFormatException("ISBN Numbers must be 10 or 13 characters.");
        if (ISBN.matches(".*[a-zA-Z&&[^xX]]+.*")) throw new NumberFormatException("Invalid ISBN Format");

        String upperISBN = ISBN.toUpperCase();
        if (ISBN.length() == 10) {
            return validate10CharISBN(upperISBN);
        } else {
            return validate13CharISBN(upperISBN);
        }
    }

    private boolean validate10CharISBN(String ISBN) {
        int total = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 9 && !Character.isDigit(ISBN.charAt(i)) && ISBN.charAt(i) != 'X')
                throw new NumberFormatException("Invalid Number Format");

            int value;
            if (ISBN.charAt(i) == 'X') value = 10;
            else value = Character.getNumericValue(ISBN.charAt(i));

            total += value * (10 - i);
        }

        return total % 11 == 0;
    }

    private boolean validate13CharISBN(String ISBN) {
        return true;
    }

}
