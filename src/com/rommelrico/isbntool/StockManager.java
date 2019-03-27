package com.rommelrico.isbntool;

class StockManager {

    private ExternalISBNDataService webService;
    private ExternalISBNDataService dbService;

    String getLocatorCode(String ISBN) {
        Book book = webService.lookup(ISBN);
        return ISBN.substring(ISBN.length() - 4) +
               book.getAuthor().substring(0, 1) +
               book.getTitle().split(" ").length;
    }

    void setService(ExternalISBNDataService service) {
        this.webService = service;
    }

    void setDbService(ExternalISBNDataService dbService) {
        this.dbService = dbService;
    }
    
}
