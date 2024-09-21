package main.java.com.baticuisine.dao;

import main.java.com.baticuisine.model.Quote;

public interface QuoteDao {
    public void addQuote(Quote quote);
    Quote getQuoteByClientName(String name);
    public void updateQuote(Quote quote);
    
}
