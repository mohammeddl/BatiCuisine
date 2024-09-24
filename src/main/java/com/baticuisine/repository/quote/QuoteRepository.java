package main.java.com.baticuisine.repository.quote;

import java.util.Optional;

import main.java.com.baticuisine.model.Quote;

public interface QuoteRepository {

    public void addQuote(Quote quote);
    Optional<Quote> getQuote(int projectId);
    public void updateQuote(Quote quote);
    
} 