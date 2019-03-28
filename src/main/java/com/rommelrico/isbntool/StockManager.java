package com.rommelrico.isbntool;

class StockManager {

    private ExternalISBNDataService webService;
    private ExternalISBNDataService dbService;

    String getLocatorCode(String ISBN) {
        Book book = dbService.lookup(ISBN);
        if (book == null) book = webService.lookup(ISBN);

        return ISBN.substring(ISBN.length() - 4) +
               book.getAuthor().substring(0, 1) +
               book.getTitle().split(" ").length;
    }

    void setWebService(ExternalISBNDataService service) {
        this.webService = service;
    }

    void setDBService(ExternalISBNDataService dbService) {
        this.dbService = dbService;
    }

}
