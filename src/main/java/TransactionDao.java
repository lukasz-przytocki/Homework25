import java.sql.*;
import java.sql.Date;

public class TransactionDao {

    public void add(Transaction transaction) {
        Connection connection = connect();

        PreparedStatement preparedStatement = null;
        try {
            String sql = "INSERT INTO transaction (type, description, amount, date)" +
                    "values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setDate(4, Date.valueOf(transaction.getDate()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Problem z zapisem do bazy" + e.getMessage());
        }
        closeConnection(connection);

    }

    public void remove(long id) {
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "DELETE FROM transaction WHERE id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Błąd podczas usuwania rekoedu: " + e.getMessage());
        }
        closeConnection(connection);
    }

    public void update(Transaction transaction) {
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "update transaction set type=?, description=?, amount=?, date=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setDate(4, Date.valueOf(transaction.getDate()));
            preparedStatement.setLong(5, transaction.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Błąd pocczas aktualizacji danych: " + e.getMessage());
        }
        closeConnection(connection);
    }

    public double displayIncome() {
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        Double totalIncome = 0.0;
        try {

            String sql = "select SUM(amount) as SUMA_WYDATKÓW from transaction where type='OUT'";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                totalIncome = resultSet.getDouble(1);
            }

        } catch (SQLException e) {
            System.out.println("Błąd podczas wyświetlania sumy wydatków: " + e.getMessage());
        }
        return totalIncome;
    }

    public double displayOutcome() {
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        Double totalOutcome = 0.0;
        try {

            String sql = "select SUM(amount) as SUMA_PRZYCHODÓW from transaction where type='IN'";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                totalOutcome = resultSet.getDouble(1);
            }

        } catch (SQLException e) {
            System.out.println("Błąd podczas wyświetlania sumy przychodów: " + e.getMessage());
        }
        return totalOutcome;
    }


    private Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/homework25?serverTimezone=UTC&characterEncoding=utf8";
        try {
            return DriverManager.getConnection(url, "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
