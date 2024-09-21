package main.java.com.baticuisine.service.quote;

import main.java.com.baticuisine.model.Quote;
import main.java.com.baticuisine.repository.quote.QuoteRepositoryImplt;

public class QuoteServiceImplt implements QuoteService {
    private final QuoteRepositoryImplt quoteRepositoryImplt;


    public QuoteServiceImplt(QuoteRepositoryImplt quoteRepositoryImplt) {
        this.quoteRepositoryImplt = quoteRepositoryImplt;
    }

    public void addQuote(Quote quote) {
        quoteRepositoryImplt.addQuote(quote);
    }

    public Quote getQuoteByClientName(String name) {
        return quoteRepositoryImplt.getQuoteByClientName(name);
    }

    public void updateQuote(Quote quote) {
        quoteRepositoryImplt.updateQuote(quote);
    }
    
}
