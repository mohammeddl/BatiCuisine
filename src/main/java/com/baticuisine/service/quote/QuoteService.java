package main.java.com.baticuisine.service.quote;

import main.java.com.baticuisine.model.Quote;

public interface QuoteService {

    public void addQuote(Quote quote);
    Quote getQuoteByClientName(String name);
    public void updateQuote(Quote quote);

    
}