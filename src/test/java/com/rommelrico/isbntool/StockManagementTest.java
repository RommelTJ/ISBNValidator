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
        ExternalISBNDataService mockDBService = mock(ExternalISBNDataService.class);
        ExternalISBNDataService mockWebService = mock(ExternalISBNDataService.class);

        when(mockDBService.lookup("0140177396")).thenReturn(new Book("0140177396", "abc", "abc"));

        StockManager stockManager = new StockManager();
        stockManager.setWebService(mockWebService);
        stockManager.setDBService(mockDBService);

        String ISBN = "0140177396"; // Of Mice and Men
        String locatorCode = stockManager.getLocatorCode(ISBN);

        // Verify that lookup(ISBN) was called 1 time for mockDBService.
        verify(mockDBService, times(1)).lookup(ISBN);

        // Verify that the lookup(ISBN) was not called on the mockWebService.
        verify(mockWebService, times(0)).lookup(anyString());
    }

    @Test
    void webServiceIsUsedIfDataIsNotPresentInDatabase() {
        ExternalISBNDataService mockDBService = mock(ExternalISBNDataService.class);
        ExternalISBNDataService mockWebService = mock(ExternalISBNDataService.class);

        when(mockDBService.lookup("0140177396")).thenReturn(null);
        when(mockWebService.lookup("0140177396")).thenReturn(new Book("0140177396", "abc", "abc"));

        StockManager stockManager = new StockManager();
        stockManager.setWebService(mockWebService);
        stockManager.setDBService(mockDBService);

        String ISBN = "0140177396"; // Of Mice and Men
        String locatorCode = stockManager.getLocatorCode(ISBN);

        // Verify that lookup(ISBN) was called 1 times for mockDBService.
        verify(mockDBService, times(1)).lookup(ISBN);

        // Verify that the lookup(ISBN) was called 1 on the mockWebService.
        verify(mockWebService, times(1)).lookup(ISBN);
    }

}