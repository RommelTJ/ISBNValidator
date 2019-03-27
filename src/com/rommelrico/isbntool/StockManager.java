package com.rommelrico.isbntool;

class StockManager {

    private ExternalISBNDataService service;

    String getLocatorCode(String ISBN) {
        Book book = service.lookup(ISBN);
        return ISBN.substring(ISBN.length() - 4) +
               book.getAuthor().substring(0, 1) +
               book.getTitle().split(" ").length;
    }

    public void setService(ExternalISBNDataService service) {
        this.service = service;
    }

}
