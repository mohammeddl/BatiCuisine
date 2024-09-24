package main.java.com.baticuisine.dao.quote;

import main.java.com.baticuisine.config.DatabaseConnection;
import main.java.com.baticuisine.model.Quote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;


public class QuoteDaoImplt implements QuoteDao {
    private static final String INSERT_QUOTE = "INSERT INTO quote (estimatedamount, issuedate, validitydate, isaccepted, project_id) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_QUOTE = "UPDATE quote SET isaccepted = ? WHERE project_id = ?";
    private static final String GET_QUOTE_BY_CLIENT_NAME = "SELECT * FROM quote WHERE project_id = ?";

    private final Connection connection;

    public QuoteDaoImplt() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public void addQuote(Quote quote) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUOTE);
            preparedStatement.setDouble(1, quote.getEstimatedAmount());
            preparedStatement.setDate(2, new java.sql.Date(quote.getIssueDate().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(quote.getValidityDate().getTime()));
            preparedStatement.setBoolean(4, quote.isAccepted());
            preparedStatement.setInt(5, quote.getProjectId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateQuote(Quote quote) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUOTE);
            preparedStatement.setBoolean(1, quote.isAccepted());
            preparedStatement.setInt(2, quote.getProjectId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Optional<Quote> getQuote(int idProject) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GET_QUOTE_BY_CLIENT_NAME);
            preparedStatement.setInt(1, idProject);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return Optional.of(new Quote(resultSet.getDouble("estimatedamount"), resultSet.getDate("issuedate"), resultSet.getDate("validitydate"), resultSet.getBoolean("isaccepted"), resultSet.getInt("project_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
        
    }
    
}
