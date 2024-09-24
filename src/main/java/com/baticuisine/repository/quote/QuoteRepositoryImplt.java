package main.java.com.baticuisine.repository.quote;

import java.util.Optional;

import main.java.com.baticuisine.dao.quote.QuoteDaoImplt;
import main.java.com.baticuisine.model.Quote;

public class QuoteRepositoryImplt implements QuoteRepository {

    private final QuoteDaoImplt quoteDaoImplt;

    public QuoteRepositoryImplt( QuoteDaoImplt quoteDaoImplt) {
        this.quoteDaoImplt = quoteDaoImplt;
    }


    
    public void addQuote(Quote quote) {
        quoteDaoImplt.addQuote(quote);
    }
    
    public Optional<Quote> getQuote(int projectId) {
        return quoteDaoImplt.getQuote(projectId);
    }

    public void updateQuote(Quote quote) {
        quoteDaoImplt.updateQuote(quote);
    }
     

     

}
