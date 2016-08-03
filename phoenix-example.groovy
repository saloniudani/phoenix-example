import java.sql.*;

public class PhoenixExample {


}

public static void main(String[] args) {
    // Create variables
    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    try {
        // Connect to the database
        connection = DriverManager.getConnection("jdbc:phoenix:localhost");

        // Create a JDBC statement
        statement = connection.createStatement();

        // Execute our statements
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS STOCK_SYMBOL (GUID VARCHAR NOT NULL, SYMBOL VARCHAR,COMPANY VARCHAR ,PRODUCT VARCHAR,COUNTRY VARCHAR,CONSTRAINT PK_STOCK_SYMBOL PRIMARY KEY(GUID))");
        statement.executeUpdate("UPSERT INTO STOCK_SYMBOL VALUES ('ee7b65ac-4b2f-4fda-a19e-161be7a3a916','CRM','SalesForce.com')");
        statement.executeUpdate("UPSERT INTO STOCK_SYMBOL VALUES ('ee7b65ac-4b2f-4fda-a19e-161be7a3a917','APL','APPLE Inc.')");
        statement.executeUpdate("UPSERT INTO STOCK_SYMBOL VALUES ('ee7b65ac-4b2f-4fda-a19e-161be7a3a918','GOG','Google')");
        statement.executeUpdate("UPSERT INTO STOCK_SYMBOL VALUES ('ee7b65ac-4b2f-4fda-a19e-161be7a3a919','HOG','Harlet-Davidson Inc.')");
        statement.executeUpdate("UPSERT INTO STOCK_SYMBOL VALUES ('ee7b65ac-4b2f-4fda-a19e-161be7a3a920','HPQ','Hewlett Packard')");
        statement.executeUpdate("UPSERT INTO STOCK_SYMBOL VALUES ('ee7b65ac-4b2f-4fda-a19e-161be7a3a921','INT','Intel')");
        statement.executeUpdate("UPSERT INTO STOCK_SYMBOL VALUES ('ee7b65ac-4b2f-4fda-a19e-161be7a3a922','MSF','Microsoft')");
        statement.executeUpdate("UPSERT INTO STOCK_SYMBOL VALUES ('ee7b65ac-4b2f-4fda-a19e-161be7a3a923','WAG','Walgreens')");
        statement.executeUpdate("UPSERT INTO STOCK_SYMBOL VALUES ('ee7b65ac-4b2f-4fda-a19e-161be7a3a924','WMT','Walmart')");

        connection.commit();

        // Query for table
        ps = connection.prepareStatement("SELECT * FROM STOCK_SYMBOL");
        rs = ps.executeQuery();

        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount()
        List<String> columnLabels = new ArrayList<>()
        print "\nCols--->  "
        for (int i = 1; i <= columnCount; i++) {
            columnLabels.add(resultSetMetaData.getColumnLabel(i))
            if (i < columnCount) {
                print resultSetMetaData.getColumnLabel(i) + "   ,   "
            } else {
                print resultSetMetaData.getColumnLabel(i)
            }

        }
        print "\n"

        while (rs.next()) {
            print "Rows--->  "
            int coulmnCounter = 1;
            for (String label : columnLabels) {
                if (coulmnCounter < columnCount) {
                    print rs.getString(label) + "   ,   "
                } else {
                    print rs.getString(label)
                }
                coulmnCounter++;
            }
            print "\n"
        }
    }
    catch (SQLException e) {
        e.printStackTrace();
    }
    finally {
        if (ps != null) {
            try {
                ps.close();
            }
            catch (Exception e) {
            }
        }
        if (rs != null) {
            try {
                rs.close();
            }
            catch (Exception e) {
            }
        }
        if (statement != null) {
            try {
                statement.close();
            }
            catch (Exception e) {
            }
        }
        if (connection != null) {
            try {
                connection.close();
            }
            catch (Exception e) {
            }
        }
    }
}