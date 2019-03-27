package com.rommelrico.isbntool;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StockManagementTest {

    @Test
    void testCanGetCorrectLocatorCode() {
        ExternalISBNDataService testWebService = new ExternalISBNDataService() {
            @Override
            public Book lookup(String ISBN) {
                return new Book(ISBN, "Of Mice And Men", "John Steinbeck");
            }
        };

        ExternalISBNDataService testDBService = new ExternalISBNDataService() {
            @Override
            public Book lookup(String ISBN) {
                return null;
            }
        };

        StockManager stockManager = new StockManager();
        stockManager.setWebService(testWebService);
        stockManager.setDBService(testDBService);

        String ISBN = "0140177396"; // Of Mice and Men
        String locatorCode = stockManager.getLocatorCode(ISBN);
        assertEquals("7396J4", locatorCode); // Expected / Actual
    }

}
