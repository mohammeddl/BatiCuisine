package main.java.com.baticuisine.repository.quote;

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
    
    public Quote getQuoteByClientName(String name) {
        return quoteDaoImplt.getQuoteByClientName(name);
    }

    public void updateQuote(Quote quote) {
        quoteDaoImplt.updateQuote(quote);
    }
     

     

}
