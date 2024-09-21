package main.java.com.baticuisine.dao.quote;

import main.java.com.baticuisine.model.Quote;

public interface QuoteDao {
    public void addQuote(Quote quote);
    Quote getQuoteByClientName(String name);
    public void updateQuote(Quote quote);
    
}
