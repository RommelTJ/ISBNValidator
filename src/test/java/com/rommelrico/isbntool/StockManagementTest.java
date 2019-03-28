package com.rommelrico.isbntool;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StockManagementTest {

    @Test
    void testCanGetCorrectLocatorCode() {
        ExternalISBNDataService testWebService = ISBN -> new Book(ISBN, "Of Mice And Men", "John Steinbeck");
        ExternalISBNDataService testDBService = ISBN -> null;

        StockManager stockManager = new StockManager();
        stockManager.setWebService(testWebService);
        stockManager.setDBService(testDBService);

        String ISBN = "0140177396"; // Of Mice and Men
        String locatorCode = stockManager.getLocatorCode(ISBN);
        assertEquals("7396J4", locatorCode); // Expected / Actual
    }

    @Test
    void databaseIsUsedIfDataIsPresent() {
        fail();
    }

    @Test
    void webServiceIsUsedIfDataIsNotPresentInDatabase() {
        fail();
    }

}
