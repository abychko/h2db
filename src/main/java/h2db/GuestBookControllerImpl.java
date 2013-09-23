package h2db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestBookControllerImpl implements GuestBookController {

    Connection connection;

    public GuestBookControllerImpl(String database, String user, String password) throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        connection = DriverManager.getConnection("jdbc:h2:" + database + ";DB_CLOSE_ON_EXIT=TRUE", user, password);
        connection.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS GUESTBOOK\n" + "(ID INTEGER auto_increment NOT NULL," + "POSTDATE TIMESTAMP NOT NULL default CURRENT_TIMESTAMP()," + "MESSAGE TEXT," + "PRIMARY KEY (ID))");

    }

    @Override
    public void addRecord(String message) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO GUESTBOOK (MESSAGE) " + "VALUES (?)");
            ps.setString(1, message);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Record> getRecords() throws SQLException {
        List<Record> records = new ArrayList<Record>();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM GUESTBOOK");
        while(resultSet.next()){
            try {
                Record tmp = new Record(resultSet.getInt("ID"), resultSet.getTimestamp("POSTDATE"), resultSet.getString("MESSAGE"));
                records.add(tmp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return records;
    }
}
