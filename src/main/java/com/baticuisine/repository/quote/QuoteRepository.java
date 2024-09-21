package main.java.com.baticuisine.repository.quote;

import main.java.com.baticuisine.model.Quote;

public interface QuoteRepository {

    public void addQuote(Quote quote);
    Quote getQuoteByClientName(String name);
    public void updateQuote(Quote quote);
    
} 