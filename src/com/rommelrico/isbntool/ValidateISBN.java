package com.rommelrico.isbntool;

class ValidateISBN {

    public static final int SHORT_ISBN_LENGTH = 10;
    public static final int LONG_ISBN_MULTIPLIER = 10;
    public static final int LONG_ISBN_LENGTH = 13;
    public static final int SHORT_ISBN_MULTIPLIER = 11;

    boolean checkISBN(String ISBN) {
        if (ISBN.length() != SHORT_ISBN_LENGTH && ISBN.length() != LONG_ISBN_LENGTH) throw new NumberFormatException("ISBN Numbers must be 10 or 13 characters.");
        if (ISBN.matches(".*[a-zA-Z&&[^xX]]+.*")) throw new NumberFormatException("Invalid ISBN Format");

        String upperISBN = ISBN.toUpperCase();
        if (ISBN.length() == SHORT_ISBN_LENGTH) {
            return validate10CharISBN(upperISBN);
        } else {
            return validate13CharISBN(upperISBN);
        }
    }

    private boolean validate10CharISBN(String ISBN) {
        int total = 0;
        for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {
            if (i == 9 && !Character.isDigit(ISBN.charAt(i)) && ISBN.charAt(i) != 'X')
                throw new NumberFormatException("Invalid Number Format");

            int value;
            if (ISBN.charAt(i) == 'X') value = SHORT_ISBN_LENGTH;
            else value = Character.getNumericValue(ISBN.charAt(i));

            total += value * (SHORT_ISBN_LENGTH - i);
        }

        return total % SHORT_ISBN_MULTIPLIER == 0;
    }

    private boolean validate13CharISBN(String ISBN) {
        int total = 0;
        for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
            if (i % 2 == 0) {
                // Even
                total += Character.getNumericValue(ISBN.charAt(i));
            } else {
                // Odd
                total += Character.getNumericValue(ISBN.charAt(i)) * 3;
            }
        }

        return total % LONG_ISBN_MULTIPLIER == 0;
    }

}
