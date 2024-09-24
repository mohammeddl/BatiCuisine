package main.java.com.baticuisine.service.quote;

import java.util.Optional;

import main.java.com.baticuisine.model.Quote;

public interface QuoteService {

    public void addQuote(Quote quote);
    Optional<Quote> getQuote(int porjectId);
    public void updateQuote(Quote quote);

    
}