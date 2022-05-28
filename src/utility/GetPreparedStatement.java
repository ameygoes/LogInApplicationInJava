package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GetPreparedStatement {
    public static PreparedStatement GetPreparedStatement(Connection connection, String PreparedStatemntString) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(PreparedStatemntString);
        return preparedStatement;
    }
}
