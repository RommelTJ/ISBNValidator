package com.rommelrico.isbntool;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StockManagementTest {

    @Test
    void testCanGetCorrectLocatorCode() {
        ExternalISBNDataService testWebService = mock(ExternalISBNDataService.class);
        ExternalISBNDataService testDBService = mock(ExternalISBNDataService.class);

        String ISBN = "0140177396"; // Of Mice and Men
        when(testWebService.lookup(ISBN)).thenReturn(new Book(ISBN, "Of Mice And Men", "John Steinbeck"));
        when(testDBService.lookup(ISBN)).thenReturn(null);

        StockManager stockManager = new StockManager();
        stockManager.setWebService(testWebService);
        stockManager.setDBService(testDBService);

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
        verify(mockDBService).lookup(ISBN);

        // Verify that the lookup(ISBN) was not called on the mockWebService.
        verify(mockWebService, never()).lookup(anyString());
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
        verify(mockDBService).lookup(ISBN);

        // Verify that the lookup(ISBN) was called 1 on the mockWebService.
        verify(mockWebService).lookup(ISBN);
    }

}
