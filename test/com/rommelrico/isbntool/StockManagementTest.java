package com.rommelrico.isbntool;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StockManagementTest {

    @Test
    void testCanGetCorrectLocatorCode() {
        String ISBN = "0140177396"; // Of Mice and Men
        StockManager stockManager = new StockManager();
        String locatorCode = stockManager.getLocatorCode(ISBN);
        assertEquals("7396J4", locatorCode); // Expected / Actual
    }

}
