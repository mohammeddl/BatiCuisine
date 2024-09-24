package main.java.com.baticuisine.dao.quote;

import java.util.Optional;

import main.java.com.baticuisine.model.Quote;

public interface QuoteDao {
    public void addQuote(Quote quote);
    Optional<Quote> getQuote(int idProject);
    public void updateQuote(Quote quote);
    
}
